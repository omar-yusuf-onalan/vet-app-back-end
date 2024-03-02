package com.omaryusufonalan.vetappbackend.dto.availabledate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailableDateCreateRequest {
    @NotNull
    private LocalDate availableDate;
}