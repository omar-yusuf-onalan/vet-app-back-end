package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.request.VaccineRequest;
import com.omaryusufonalan.vetappbackend.service.VaccineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("vaccines")
@RequiredArgsConstructor
public class VaccineController {
    private final VaccineService vaccineService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(vaccineService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(vaccineService.getResponseById(id), HttpStatus.OK);
    }

    @GetMapping("filter-by-animal-name/{animalName}")
    public ResponseEntity<?> filterByAnimalName(@PathVariable("animalName") String animalName){
        return new ResponseEntity<>(vaccineService.filterVaccineResponsesByAnimalName(animalName), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> filterByTwoDates(
            @RequestParam("start-date") LocalDate startDate,
            @RequestParam("finish-date") LocalDate finishDate
    ){
        return new ResponseEntity<>(
                vaccineService.findAllVaccineResponsesBetweenTwoDates(startDate, finishDate),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody VaccineRequest vaccineRequest) {
        return new ResponseEntity<>(vaccineService.create(vaccineRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody VaccineRequest vaccineRequest
    ){
        return new ResponseEntity<>(vaccineService.update(id, vaccineRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        vaccineService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}