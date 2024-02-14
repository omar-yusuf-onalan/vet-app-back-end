package com.omaryusufonalan.vetappbackend.dto.animal;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnimalRequest {
    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate dateOfBirth;

    private CustomerInAnimalRequest customer;
}
