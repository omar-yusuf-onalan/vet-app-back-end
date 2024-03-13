package com.omaryusufonalan.vetappbackend.dto.request;

import com.omaryusufonalan.vetappbackend.dto.only.OnlyAnimalDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyDoctorDTO;
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
public class AppointmentRequest {
    @NotNull
    private LocalDateTime appointmentDate;

    private OnlyDoctorDTO doctor;

    private OnlyAnimalDTO animal;
}
