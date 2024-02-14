package com.omaryusufonalan.vetappbackend.dto.doctor;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentWithoutAnythingResponse;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DoctorWithoutAvailableDateResponse {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;

    private Set<AppointmentWithoutAnythingResponse> appointments;
}
