package com.omaryusufonalan.vetappbackend.dto.availabledate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DoctorInAvailableDateRequest {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}
