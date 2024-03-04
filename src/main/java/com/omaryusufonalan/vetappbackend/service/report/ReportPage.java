package com.omaryusufonalan.vetappbackend.service.report;

import com.omaryusufonalan.vetappbackend.dto.report.ReportResponse;
import com.omaryusufonalan.vetappbackend.entity.Report;

import java.util.List;

public interface ReportPage {
    List<Report> getReportPage(int page, int pageSize);
    List<ReportResponse> getReportResponsePage(int page, int pageSize);
}
