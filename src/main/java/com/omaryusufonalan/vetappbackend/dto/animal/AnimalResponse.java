package com.omaryusufonalan.vetappbackend.dto.animal;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerWithoutAnimalResponse;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnimalResponse {
    private Long id;

    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate dateOfBirth;

    private CustomerWithoutAnimalResponse customer;
}
