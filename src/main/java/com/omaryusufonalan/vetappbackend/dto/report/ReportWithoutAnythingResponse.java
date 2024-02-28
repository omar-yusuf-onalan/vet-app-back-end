package com.omaryusufonalan.vetappbackend.dto.report;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReportWithoutAnythingResponse {
    private Long id;

    private String title;

    private String diagnosis;

    private double price;
}
