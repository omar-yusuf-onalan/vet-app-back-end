package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.report.ReportCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.report.ReportUpdateRequest;
import com.omaryusufonalan.vetappbackend.service.report.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(reportService.getReportResponseById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "page-size", required = false, defaultValue = "10") int pageSize
    ) {
        return new ResponseEntity<>(reportService.getReportResponsePage(page, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ReportCreateRequest reportCreateRequest) {
        return new ResponseEntity<>(reportService.createReport(reportCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody ReportUpdateRequest reportUpdateRequest){
        return new ResponseEntity<>(reportService.updateReport(reportUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        reportService.deleteReportById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
