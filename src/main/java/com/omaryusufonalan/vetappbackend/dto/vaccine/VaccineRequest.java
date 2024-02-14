package com.omaryusufonalan.vetappbackend.dto.vaccine;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VaccineRequest {
    private String name;

    private String code;

    private LocalDate protectionStartDate;

    private LocalDate protectionFinishDate;

    private AnimalInVaccineRequest animal;
}
