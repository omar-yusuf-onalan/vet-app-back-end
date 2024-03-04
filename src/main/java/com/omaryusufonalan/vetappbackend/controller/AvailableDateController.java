package com.omaryusufonalan.vetappbackend.controller;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateUpdateRequest;
import com.omaryusufonalan.vetappbackend.service.availabledate.AvailableDateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omaryusufonalan.vetappbackend.config.BaseURL.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "availableDates")
@RequiredArgsConstructor
public class AvailableDateController {
    private final AvailableDateService availableDateService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(availableDateService.getAvailableDateResponseById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "page-size", required = false, defaultValue = "10") int pageSize
    ) {
        return new ResponseEntity<>(availableDateService.getAvailableDateResponsePage(page, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AvailableDateCreateRequest availableDateCreateRequest) {
        return new ResponseEntity<>(availableDateService.createAvailableDate(availableDateCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest){
        return new ResponseEntity<>(availableDateService.updateAvailableDate(availableDateUpdateRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        availableDateService.deleteAvailableDateById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
