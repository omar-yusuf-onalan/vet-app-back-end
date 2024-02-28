package com.omaryusufonalan.vetappbackend.dto.vaccine;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReportInVaccineRequest {
    private Long id;

    private String title;

    private String diagnosis;

    private double price;
}
