package com.omaryusufonalan.vetappbackend.dto.report;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReportRequest {
    private String title;

    private String diagnosis;

    private double price;
}
