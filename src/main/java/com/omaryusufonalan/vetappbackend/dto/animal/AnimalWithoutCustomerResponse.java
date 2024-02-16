package com.omaryusufonalan.vetappbackend.dto.animal;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentWithoutAnythingResponse;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineWithoutAnimalResponse;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnimalWithoutCustomerResponse {
    private Long id;

    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate dateOfBirth;

    private Set<VaccineWithoutAnimalResponse> vaccines;

    private Set<AppointmentWithoutAnythingResponse> appointments;
}
