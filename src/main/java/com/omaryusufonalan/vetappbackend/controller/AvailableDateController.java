package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateRequest;
import com.omaryusufonalan.vetappbackend.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vet-app/api/v1/availableDate")
@RequiredArgsConstructor
public class AvailableDateController {
    private final AvailableDateService availableDateService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getResponseById(@PathVariable Long id) {
        return new ResponseEntity<>(availableDateService.getResponseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AvailableDateRequest availableDateRequest) {
        return new ResponseEntity<>(availableDateService.create(availableDateRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AvailableDateRequest availableDateRequest) {
        return new ResponseEntity<>(availableDateService.update(id, availableDateRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        availableDateService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
