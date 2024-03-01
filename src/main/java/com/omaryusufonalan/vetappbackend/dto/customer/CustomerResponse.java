package com.omaryusufonalan.vetappbackend.dto.customer;

import com.omaryusufonalan.vetappbackend.dto.animal.OnlyAnimalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private Long id;

    private String name;

    private String phone;

    private String email;

    private String address;

    private String city;

    private List<OnlyAnimalResponse> animals;
}
