package com.omaryusufonalan.vetappbackend.dto.request;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyDoctorDTO;
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
public class AvailableDateRequest {
    @NotNull
    private LocalDate availableDate;

    private OnlyDoctorDTO doctor;
}
