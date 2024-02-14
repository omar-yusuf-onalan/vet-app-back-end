package com.omaryusufonalan.vetappbackend.dto.availabledate;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorWithoutAvailableDateResponse;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AvailableDateResponse {
    private Long id;

    private LocalDate availableDate;

    private DoctorWithoutAvailableDateResponse doctor;
}
