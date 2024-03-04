package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import com.omaryusufonalan.vetappbackend.service.doctor.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(doctorService.getDoctorResponseById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "page-size", required = false, defaultValue = "10") int pageSize
    ) {
        return new ResponseEntity<>(doctorService.getDoctorResponsePage(page, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DoctorCreateRequest doctorCreateRequest) {
        return new ResponseEntity<>(doctorService.createDoctor(doctorCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest){
        return new ResponseEntity<>(doctorService.updateDoctor(doctorUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
