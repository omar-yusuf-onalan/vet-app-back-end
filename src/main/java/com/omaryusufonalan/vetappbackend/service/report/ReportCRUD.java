package com.omaryusufonalan.vetappbackend.service.report;

import com.omaryusufonalan.vetappbackend.dto.report.ReportCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.report.ReportResponse;
import com.omaryusufonalan.vetappbackend.dto.report.ReportUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Report;

import java.util.List;

public interface ReportCRUD {
    List<Report> getAllReports();
    List<ReportResponse> getAllReportResponses();
    Report getReportById(Long id);
    ReportResponse getReportResponseById(Long id);
    ReportResponse createReport(ReportCreateRequest reportCreateRequest);
    ReportResponse updateReport(ReportUpdateRequest reportUpdateRequest);
    void deleteReportById(Long id);
}
