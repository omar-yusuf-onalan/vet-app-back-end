package com.omaryusufonalan.vetappbackend.dto.report;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentInReportRequest {
    private Long id;

    private LocalDateTime appointmentDate;
}
