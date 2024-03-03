package com.omaryusufonalan.vetappbackend.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlyReportResponse {
    private Long id;

    private String title;

    private String diagnosis;

    private double price;
}
