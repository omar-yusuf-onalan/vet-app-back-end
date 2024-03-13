package com.omaryusufonalan.vetappbackend.controller;


import com.omaryusufonalan.vetappbackend.dto.customer.CustomerUpdateRequest;
import com.omaryusufonalan.vetappbackend.dto.request.CustomerRequest;
import com.omaryusufonalan.vetappbackend.service.customer.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(customerService.getAllCustomerResponses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(customerService.getCustomerResponseById(id), HttpStatus.OK);
    }

    @GetMapping("/filter-by-name/{name}")
    public ResponseEntity<?> filterByName(@PathVariable("name") String name){
        return new ResponseEntity<>(customerService.filterCustomerResponsesByName(name), HttpStatus.OK);
    }

    @GetMapping("animals/{id}")
    public ResponseEntity<?> getAnimals(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.getCustomerAnimalResponses(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CustomerRequest customerRequest) {
        return new ResponseEntity<>(customerService.createCustomer(customerRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest){
        return new ResponseEntity<>(customerService.updateCustomer(customerUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
