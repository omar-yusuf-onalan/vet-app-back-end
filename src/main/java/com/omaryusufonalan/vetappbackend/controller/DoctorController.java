package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import com.omaryusufonalan.vetappbackend.dto.request.DoctorRequest;
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

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(doctorService.getAllDoctorResponses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(doctorService.getDoctorResponseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DoctorRequest doctorRequest) {
        return new ResponseEntity<>(doctorService.createDoctor(doctorRequest), HttpStatus.CREATED);
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
