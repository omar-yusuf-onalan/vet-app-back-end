package com.omaryusufonalan.vetappbackend.dto.doctor;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateWithoutDoctorResponse;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DoctorResponse {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;

    private Set<AvailableDateWithoutDoctorResponse> availableDates;
}
