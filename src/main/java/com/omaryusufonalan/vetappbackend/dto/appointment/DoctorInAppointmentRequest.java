package com.omaryusufonalan.vetappbackend.dto.appointment;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DoctorInAppointmentRequest {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}
