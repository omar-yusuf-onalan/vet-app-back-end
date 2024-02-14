package com.omaryusufonalan.vetappbackend.dto.doctor;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DoctorRequest {
    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}