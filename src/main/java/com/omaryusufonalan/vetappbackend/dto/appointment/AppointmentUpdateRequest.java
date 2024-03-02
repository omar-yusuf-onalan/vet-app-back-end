package com.omaryusufonalan.vetappbackend.dto.appointment;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalUpdateRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentUpdateRequest {
    @Positive
    private Long id;

    @NotNull
    private LocalDateTime appointmentDate;

    private DoctorUpdateRequest doctor;

    private AnimalUpdateRequest animal;
}
