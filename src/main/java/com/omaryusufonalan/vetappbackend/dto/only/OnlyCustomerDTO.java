package com.omaryusufonalan.vetappbackend.dto.only;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlyCustomerDTO {
    private Long id;

    private String name;

    private String phone;

    private String email;

    private String address;

    private String city;
}
