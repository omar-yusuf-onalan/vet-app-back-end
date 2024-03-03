package com.omaryusufonalan.vetappbackend.dto.report;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentUpdateRequest;
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
public class ReportCreateRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String diagnosis;

    @PositiveOrZero
    private double price;

    private AppointmentUpdateRequest appointment;
}
