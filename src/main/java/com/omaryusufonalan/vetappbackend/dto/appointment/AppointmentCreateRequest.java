package com.omaryusufonalan.vetappbackend.dto.appointment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentCreateRequest {
    @NotNull
    private LocalDateTime appointmentDate;
}
