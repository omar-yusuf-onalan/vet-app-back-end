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
@RequestMapping(BASE_URL + "appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(appointmentService.getAllAppointmentResponses(), HttpStatus.OK);
    }

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

    @GetMapping("/page")
    public ResponseEntity<?> getPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "page-size", required = false, defaultValue = "10") int pageSize
    ) {
        return new ResponseEntity<>(appointmentService.getAppointmentResponsePage(page, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AppointmentCreateRequest appointmentCreateRequest) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentCreateRequest), HttpStatus.CREATED);
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
