package com.omaryusufonalan.vetappbackend.dto.only;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlyReportDTO {
    private Long id;

    private String title;

    private String diagnosis;

    private double price;
}
