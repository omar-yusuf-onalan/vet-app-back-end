package com.omaryusufonalan.vetappbackend.dto.appointment;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalWithoutAppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorWithoutAppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.report.ReportWithoutAnythingResponse;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentResponse {
    private Long id;

    private LocalDateTime appointmentDate;

    private AnimalWithoutAppointmentResponse animal;

    private DoctorWithoutAppointmentResponse doctor;

    private ReportWithoutAnythingResponse report;
}
