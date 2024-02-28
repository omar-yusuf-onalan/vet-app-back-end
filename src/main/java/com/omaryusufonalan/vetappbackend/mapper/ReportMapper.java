package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.dto.report.ReportRequest;
import com.omaryusufonalan.vetappbackend.dto.report.ReportResponse;
import com.omaryusufonalan.vetappbackend.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ReportMapper {
    Report asReport(ReportRequest reportRequest);

    ReportResponse asReportResponse(Report report);

    void update(@MappingTarget Report report, ReportRequest reportRequest);
}
