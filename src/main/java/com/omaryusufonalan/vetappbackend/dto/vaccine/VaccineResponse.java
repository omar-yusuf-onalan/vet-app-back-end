package com.omaryusufonalan.vetappbackend.dto.vaccine;

import com.omaryusufonalan.vetappbackend.dto.animal.OnlyAnimalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VaccineResponse {
    private Long id;

    private String name;

    private String code;

    private LocalDate protectionStartDate;

    private LocalDate protectionFinishDate;

    private OnlyAnimalResponse animal;
}
