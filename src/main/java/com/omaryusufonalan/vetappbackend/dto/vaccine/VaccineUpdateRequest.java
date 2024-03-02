package com.omaryusufonalan.vetappbackend.dto.vaccine;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalUpdateRequest;
import jakarta.validation.constraints.NotBlank;
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
public class VaccineUpdateRequest {
    @Positive
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotNull
    private LocalDate protectionStartDate;

    @NotNull
    private LocalDate protectionFinishDate;

    private AnimalUpdateRequest animal;
}
