package com.omaryusufonalan.vetappbackend.dto.report;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentWithoutAnythingResponse;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineWithoutAnythingResponse;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReportResponse {
    private Long id;

    private String title;

    private String diagnosis;

    private double price;

    private AppointmentWithoutAnythingResponse appointment;

    private Set<VaccineWithoutAnythingResponse> vaccines;
}
