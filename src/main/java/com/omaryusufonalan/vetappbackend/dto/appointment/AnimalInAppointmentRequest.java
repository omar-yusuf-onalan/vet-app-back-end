package com.omaryusufonalan.vetappbackend.dto.appointment;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnimalInAppointmentRequest {
    private Long id;

    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate dateOfBirth;
}
