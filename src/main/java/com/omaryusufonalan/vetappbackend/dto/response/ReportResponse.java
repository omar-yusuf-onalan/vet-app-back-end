package com.omaryusufonalan.vetappbackend.dto.response;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyAppointmentDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyVaccineDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportResponse {
    private Long id;

    private String title;

    private String diagnosis;

    private double price;

    private OnlyAppointmentDTO appointment;

    private List<OnlyVaccineDTO> vaccines;
}
