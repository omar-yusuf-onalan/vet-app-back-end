package com.omaryusufonalan.vetappbackend.dto.appointment;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentRequest {
    private LocalDateTime appointmentDate;

    private AnimalInAppointmentRequest animal;

    private DoctorInAppointmentRequest doctor;
}
