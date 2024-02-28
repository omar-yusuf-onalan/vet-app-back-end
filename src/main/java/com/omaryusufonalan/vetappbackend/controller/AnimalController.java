package com.omaryusufonalan.vetappbackend.controller;


import com.omaryusufonalan.vetappbackend.dto.animal.AnimalRequest;
import com.omaryusufonalan.vetappbackend.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/animals")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getResponseById(@PathVariable Long id) {
        return new ResponseEntity<>(animalService.getResponseById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPageResponse(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize)
    {
        return new ResponseEntity<>(animalService.getPageResponse(page, pageSize), HttpStatus.OK);
    }

    @GetMapping("/administered-vaccines/{id}")
    public ResponseEntity<?> getAllAdministeredVaccineWithoutAnimalResponses(@PathVariable Long id) {
        return new ResponseEntity<>(animalService.getAllAdministeredVaccineWithoutAnythingResponses(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AnimalRequest animalRequest) {
        return new ResponseEntity<>(animalService.create(animalRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AnimalRequest animalRequest) {
        return new ResponseEntity<>(animalService.update(id, animalRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        animalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
