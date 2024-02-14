package com.omaryusufonalan.vetappbackend.dto.appointment;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentWithoutAnythingResponse {
    private Long id;

    private LocalDateTime appointmentDate;
}
