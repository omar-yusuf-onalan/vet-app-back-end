package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentUpdateRequest;
import com.omaryusufonalan.vetappbackend.service.appointment.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(appointmentService.getAppointmentResponseById(id), HttpStatus.OK);
    }

    @GetMapping("/filter-by-doctor-id-and-two-dates/{doctorId}/{startDate}/{finishDate}")
    public ResponseEntity<?> filterAppointmentResponsesByDoctorIdAndTwoDates(
            @PathVariable("doctorId") Long doctorId,
            @PathVariable("startDate") LocalDate startDate,
            @PathVariable("finishDate") LocalDate finishDate
    ){
        return new ResponseEntity<>(appointmentService.filterAppointmentResponsesByDoctorIdAndTwoDates(
                doctorId,
                startDate,
                finishDate
        ), HttpStatus.OK);
    }

    @GetMapping("/filter-by-animal-id-and-two-dates/{doctorId}/{startDate}/{finishDate}")
    public ResponseEntity<?> filterAppointmentResponsesByAnimalIdAndTwoDates(
            @PathVariable("animalId") Long animalId,
            @PathVariable("startDate") LocalDate startDate,
            @PathVariable("finishDate") LocalDate finishDate
    ){
        return new ResponseEntity<>(appointmentService.filterAppointmentResponsesByAnimalIdAndTwoDates(
                animalId,
                startDate,
                finishDate
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AppointmentCreateRequest appointmentSaveRequest) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentSaveRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
