package com.omaryusufonalan.vetappbackend.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlyAppointmentResponse {
    private Long id;

    private LocalDateTime appointmentDate;
}
