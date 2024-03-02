package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface FilterAppointment {
    List<Appointment> getAppointmentsByDoctorIdAndTwoDates(
            Long doctorId,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<AppointmentResponse> getAppointmentResponsesByDoctorIdAndTwoDates(
            Long doctorId,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<Appointment> getAppointmentsByAnimalIdAndTwoDates(
            Long animalId,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<AppointmentResponse> getAppointmentResponsesByAnimalIdAndTwoDates(
            Long animalId,
            LocalDate startDate,
            LocalDate finishDate
    );
}
