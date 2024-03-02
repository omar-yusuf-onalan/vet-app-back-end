package com.omaryusufonalan.vetappbackend.dto.availabledate;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailableDateUpdateRequest {
    @Positive
    private Long id;

    @NotNull
    private LocalDate availableDate;

    private DoctorUpdateRequest doctor;
}
