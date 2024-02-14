package com.omaryusufonalan.vetappbackend.dto.vaccine;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VaccineResponse {
    private Long id;

    private String name;

    private String code;

    private LocalDate protectionStartDate;

    private LocalDate protectionFinishDate;

    private AnimalResponse animal;
}
