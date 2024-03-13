package com.omaryusufonalan.vetappbackend.dto.request;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyAnimalDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyReportDTO;
import jakarta.validation.constraints.NotBlank;
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
public class VaccineRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotNull
    private LocalDate protectionStartDate;

    @NotNull
    private LocalDate protectionFinishDate;

    private OnlyAnimalDTO animal;

    private OnlyReportDTO report;
}
