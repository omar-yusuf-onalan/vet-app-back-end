package com.omaryusufonalan.vetappbackend.dto.animal;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerInAnimalRequest {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;
}
