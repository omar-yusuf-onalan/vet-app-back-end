package com.omaryusufonalan.vetappbackend.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerUpdateRequest {
    @Positive
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @Email
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String city;
}
