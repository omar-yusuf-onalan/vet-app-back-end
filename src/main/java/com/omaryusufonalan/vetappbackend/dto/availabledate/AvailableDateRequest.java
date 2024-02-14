package com.omaryusufonalan.vetappbackend.dto.availabledate;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AvailableDateRequest {
    private LocalDate availableDate;

    private DoctorInAvailableDateRequest doctor;
}
