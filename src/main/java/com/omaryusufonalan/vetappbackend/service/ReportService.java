package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.core.ServiceTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.ReportRequest;
import com.omaryusufonalan.vetappbackend.dto.response.ReportResponse;
import com.omaryusufonalan.vetappbackend.entity.Report;
import com.omaryusufonalan.vetappbackend.mapper.ReportMapper;
import com.omaryusufonalan.vetappbackend.repository.ReportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService implements ServiceTemplate<Report, ReportRequest, ReportResponse> {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    public List<ReportResponse> getAll() {
        return reportMapper.entityToListResponse(reportRepository.findAll());
    }

    @Override
    public Report getById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Report with ID " + id + " not found!"));
    }

    @Override
    public ReportResponse getResponseById(Long id) {
        return reportMapper.entityToResponse(getById(id));
    }

    @Override
    public ReportResponse create(ReportRequest reportRequest) {
        return reportMapper.entityToResponse(
                reportRepository.save(
                        reportMapper.requestToEntity(reportRequest)
                )
        );
    }

    @Override
    public ReportResponse update(Long id, ReportRequest reportRequest) {
        Report reportFromDb = getById(id);

        reportMapper.update(reportFromDb, reportRequest);

        return reportMapper.entityToResponse(reportRepository.save(reportFromDb));
    }

    @Override
    public void deleteById(Long id) {
        reportRepository.delete(getById(id));
    }
}
