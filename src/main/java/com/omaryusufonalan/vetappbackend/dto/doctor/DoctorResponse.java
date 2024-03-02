package com.omaryusufonalan.vetappbackend.dto.doctor;

import com.omaryusufonalan.vetappbackend.dto.appointment.OnlyAppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.availabledate.OnlyAvailableDateResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorResponse {
    private Long id;

    private String name;

    private String phone;

    private String email;

    private String address;

    private String city;

    private List<OnlyAvailableDateResponse> availableDates;

    private List<OnlyAppointmentResponse> appointments;
}
