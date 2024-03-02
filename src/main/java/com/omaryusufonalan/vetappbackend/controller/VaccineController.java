package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineUpdateRequest;
import com.omaryusufonalan.vetappbackend.service.vaccine.VaccineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/vaccines")
@RequiredArgsConstructor
public class VaccineController {
    private final VaccineService vaccineService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(vaccineService.getVaccineResponseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody VaccineCreateRequest vaccineSaveRequest) {
        return new ResponseEntity<>(vaccineService.createVaccine(vaccineSaveRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest){
        return new ResponseEntity<>(vaccineService.updateVaccine(vaccineUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        vaccineService.deleteVaccineById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}