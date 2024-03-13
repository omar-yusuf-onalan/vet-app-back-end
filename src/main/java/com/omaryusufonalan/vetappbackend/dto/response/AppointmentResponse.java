package com.omaryusufonalan.vetappbackend.dto.response;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyAnimalDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyDoctorDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyReportDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentResponse {
    private Long id;

    private LocalDateTime appointmentDate;

    private OnlyDoctorDTO doctor;

    private OnlyAnimalDTO animal;

    private OnlyReportDTO report;
}
