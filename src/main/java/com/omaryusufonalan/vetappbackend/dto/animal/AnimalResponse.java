package com.omaryusufonalan.vetappbackend.dto.animal;

import com.omaryusufonalan.vetappbackend.dto.customer.OnlyCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimalResponse {
    private Long id;

    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate dateOfBirth;

    private OnlyCustomerResponse customer;
}
