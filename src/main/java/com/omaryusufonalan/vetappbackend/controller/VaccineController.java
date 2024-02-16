package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineRequest;
import com.omaryusufonalan.vetappbackend.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vet-app/api/v1/vaccine")
@RequiredArgsConstructor
public class VaccineController {
    private final VaccineService vaccineService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getResponseById(@PathVariable Long id) {
        return new ResponseEntity<>(vaccineService.getResponseById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPageResponse(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize)
    {
        return new ResponseEntity<>(vaccineService.getPageResponse(page, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VaccineRequest vaccineRequest) {
        return new ResponseEntity<>(vaccineService.create(vaccineRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody VaccineRequest vaccineRequest) {
        return new ResponseEntity<>(vaccineService.update(id, vaccineRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vaccineService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
