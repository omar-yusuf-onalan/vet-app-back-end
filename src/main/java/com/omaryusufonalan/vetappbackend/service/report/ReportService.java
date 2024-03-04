package com.omaryusufonalan.vetappbackend.service.report;

import com.omaryusufonalan.vetappbackend.dto.report.ReportCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.report.ReportResponse;
import com.omaryusufonalan.vetappbackend.dto.report.ReportUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Report;
import com.omaryusufonalan.vetappbackend.repository.ReportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService implements ReportCRUD, ReportPage {
    private final ReportRepository reportRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Report with ID " + id + " not found!"));
    }

    @Override
    public ReportResponse getReportResponseById(Long id) {
        return modelMapper.map(getReportById(id), ReportResponse.class);
    }

    @Override
    public ReportResponse createReport(ReportCreateRequest reportCreateRequest) {
        Report reportToBeCreated = modelMapper.map(reportCreateRequest, Report.class);

        return modelMapper.map(reportRepository.save(reportToBeCreated), ReportResponse.class);
    }

    @Override
    public ReportResponse updateReport(ReportUpdateRequest reportUpdateRequest) {
        Report doesReportExist = getReportById(reportUpdateRequest.getId());

        modelMapper.map(reportUpdateRequest, doesReportExist);

        return modelMapper.map(reportRepository.save(doesReportExist), ReportResponse.class);
    }

    @Override
    public void deleteReportById(Long id) {
        reportRepository.delete(getReportById(id));
    }

    @Override
    public List<Report> getReportPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Report> reportPage = reportRepository.findAll(pageable);

        return reportPage.stream().toList();
    }

    @Override
    public List<ReportResponse> getReportResponsePage(int page, int pageSize) {
        return getReportPage(page, pageSize)
                .stream().map(report -> modelMapper.map(report, ReportResponse.class))
                .toList();
    }
}
