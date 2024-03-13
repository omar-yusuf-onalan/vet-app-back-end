package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalUpdateRequest;
import com.omaryusufonalan.vetappbackend.dto.request.AnimalRequest;
import com.omaryusufonalan.vetappbackend.service.animal.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "animals")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(animalService.getAllAnimalResponses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(animalService.getAnimalResponseById(id), HttpStatus.OK);
    }

    @GetMapping("filter-by-name/{name}")
    public ResponseEntity<?> filterByName(@PathVariable("name") String name){
        return new ResponseEntity<>(animalService.filterAnimalResponsesByName(name), HttpStatus.OK);
    }

    @GetMapping("filter-by-customer-name/{customerName}")
    public ResponseEntity<?> filterByCustomerName(@PathVariable("customerName") String customerName){
        return new ResponseEntity<>(animalService.getAnimalResponsesByCustomerName(customerName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AnimalRequest animalRequest) {
        return new ResponseEntity<>(animalService.createAnimal(animalRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest){
        return new ResponseEntity<>(animalService.updateAnimal(animalUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        animalService.deleteAnimalById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
