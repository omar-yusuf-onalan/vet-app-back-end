package com.omaryusufonalan.vetappbackend.service.report;

import com.omaryusufonalan.vetappbackend.dto.report.ReportCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.report.ReportResponse;
import com.omaryusufonalan.vetappbackend.dto.report.ReportUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Report;
import com.omaryusufonalan.vetappbackend.repository.ReportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService implements ReportCRUD {
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
}
