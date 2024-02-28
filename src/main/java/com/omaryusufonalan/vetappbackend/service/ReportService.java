package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.report.ReportRequest;
import com.omaryusufonalan.vetappbackend.dto.report.ReportResponse;
import com.omaryusufonalan.vetappbackend.dto.page.PageResponse;
import com.omaryusufonalan.vetappbackend.entity.Report;
import com.omaryusufonalan.vetappbackend.mapper.ReportMapper;
import com.omaryusufonalan.vetappbackend.repository.ReportRepository;
import com.omaryusufonalan.vetappbackend.service.interfaces.GenericCRUD;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService implements GenericCRUD<Report, ReportRequest, ReportResponse> {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;
    private final PageService<ReportResponse> pageService;

    @Override
    public Report getById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Report with ID " + id + " not found"));
    }

    @Override
    public ReportResponse getResponseById(Long id) {
        Report reportRetrievedFromDatabase = getById(id);

        return reportMapper.asReportResponse(reportRetrievedFromDatabase);
    }

    @Override
    public PageResponse<ReportResponse> getPageResponse(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Report> pageOfReports = reportRepository.findAll(pageable);

        Page<ReportResponse> pageOfReportResponses = pageOfReports
                .map(report -> reportMapper.asReportResponse(report));

        return pageService.createPageResponse(page, pageSize, pageOfReportResponses);
    }

    @Override
    public ReportResponse create(ReportRequest reportRequest) {
        Report reportToBeCreated = reportMapper.asReport(reportRequest);

        Report copyReturnedFromDatabase = reportRepository.save(reportToBeCreated);

        return reportMapper.asReportResponse(copyReturnedFromDatabase);
    }

    @Override
    public ReportResponse update(Long id, ReportRequest reportRequest) {
        Report reportToBeUpdated = getById(id);

        reportMapper.update(reportToBeUpdated, reportRequest);

        Report copyReturnedFromTheDatabase = reportRepository.save(reportToBeUpdated);

        return reportMapper.asReportResponse(copyReturnedFromTheDatabase);
    }

    @Override
    public void delete(Long id) {
        Report reportToBeDeleted = getById(id);

        reportRepository.delete(reportToBeDeleted);
    }
}
