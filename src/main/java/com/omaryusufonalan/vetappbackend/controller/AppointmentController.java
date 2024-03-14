package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.request.AppointmentRequest;
import com.omaryusufonalan.vetappbackend.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(appointmentService.getResponseById(id), HttpStatus.OK);
    }

    @GetMapping("/filter-by-doctor-name-and-two-dates/{doctorName}/{startDate}/{finishDate}")
    public ResponseEntity<?> filterAppointmentResponsesByDoctorNameAndTwoDates(
            @PathVariable("doctorName") String doctorName,
            @PathVariable("startDate") LocalDate startDate,
            @PathVariable("finishDate") LocalDate finishDate
    ){
        return new ResponseEntity<>(appointmentService.filterAppointmentResponsesByDoctorNameAndTwoDates(
                doctorName,
                startDate,
                finishDate
        ), HttpStatus.OK);
    }

    @GetMapping("/filter-by-animal-name-and-two-dates/{animalName}/{startDate}/{finishDate}")
    public ResponseEntity<?> filterAppointmentResponsesByAnimalNameAndTwoDates(
            @PathVariable("animalName") String animalName,
            @PathVariable("startDate") LocalDate startDate,
            @PathVariable("finishDate") LocalDate finishDate
    ){
        return new ResponseEntity<>(appointmentService.filterAppointmentResponsesByAnimalNameAndTwoDates(
                animalName,
                startDate,
                finishDate
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AppointmentRequest appointmentRequest) {
        return new ResponseEntity<>(appointmentService.create(appointmentRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody AppointmentRequest appointmentRequest
    ){
        return new ResponseEntity<>(appointmentService.update(id, appointmentRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        appointmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
