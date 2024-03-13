package com.omaryusufonalan.vetappbackend.dto.request;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyCustomerDTO;
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
public class AnimalRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String species;

    @NotBlank
    private String breed;

    @NotBlank
    private String gender;

    @NotBlank
    private String color;

    @NotNull
    private LocalDate dateOfBirth;

    private OnlyCustomerDTO customer;
}
