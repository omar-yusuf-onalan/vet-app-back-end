package com.omaryusufonalan.vetappbackend.dto.customer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerWithoutAnimalResponse {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}
