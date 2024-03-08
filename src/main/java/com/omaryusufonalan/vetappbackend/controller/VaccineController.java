package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineUpdateRequest;
import com.omaryusufonalan.vetappbackend.service.vaccine.VaccineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "vaccines")
@RequiredArgsConstructor
public class VaccineController {
    private final VaccineService vaccineService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(vaccineService.getAllVaccineResponses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(vaccineService.getVaccineResponseById(id), HttpStatus.OK);
    }

    @GetMapping("filter-by-animal-id/{animalId}")
    public ResponseEntity<?> filterByAnimalId(@PathVariable("animalId") Long animalId){
        return new ResponseEntity<>(vaccineService.filterVaccineResponsesByAnimalId(animalId), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> filterByTwoDates(
            @RequestParam("start-date") LocalDate startDate,
            @RequestParam("finish-date")LocalDate finishDate
    ){
        return new ResponseEntity<>(
                vaccineService.findAllVaccineResponsesBetweenTwoDates(startDate, finishDate),
                HttpStatus.OK
        );
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "page-size", required = false, defaultValue = "10") int pageSize
    ) {
        return new ResponseEntity<>(vaccineService.getVaccineResponsePage(page, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody VaccineCreateRequest vaccineCreateRequest) {
        return new ResponseEntity<>(vaccineService.createVaccine(vaccineCreateRequest), HttpStatus.CREATED);
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