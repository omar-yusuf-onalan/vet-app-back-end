package com.omaryusufonalan.vetappbackend.dto.availabledate;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AvailableDateWithoutDoctorResponse {
    private Long id;

    private LocalDate availableDate;
}
