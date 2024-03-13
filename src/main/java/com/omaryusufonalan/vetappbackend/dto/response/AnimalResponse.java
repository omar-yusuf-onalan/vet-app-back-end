package com.omaryusufonalan.vetappbackend.dto.response;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyAppointmentDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyCustomerDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyVaccineDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    private OnlyCustomerDTO customer;

    private List<OnlyVaccineDTO> vaccines;

    private List<OnlyAppointmentDTO> appointments;
}
