package com.omaryusufonalan.vetappbackend.dto.customer;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalWithoutCustomerResponse;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerResponse {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;

    private Set<AnimalWithoutCustomerResponse> animals;
}
