package com.omaryusufonalan.vetappbackend.dto.animal;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentWithoutAnythingResponse;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineWithoutAnythingResponse;
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

    private Set<VaccineWithoutAnythingResponse> vaccines;

    private Set<AppointmentWithoutAnythingResponse> appointments;
}
