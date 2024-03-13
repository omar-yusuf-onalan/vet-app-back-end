package com.omaryusufonalan.vetappbackend.dto.request;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyAppointmentDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String diagnosis;

    @PositiveOrZero
    private double price;

    private OnlyAppointmentDTO appointment;
}
