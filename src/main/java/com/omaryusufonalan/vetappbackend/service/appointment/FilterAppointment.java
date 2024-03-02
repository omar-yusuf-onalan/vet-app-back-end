package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface FilterAppointment {
    List<Appointment> filterAppointmentsByDoctorIdAndTwoDates(
            Long doctorId,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<AppointmentResponse> filterAppointmentResponsesByDoctorIdAndTwoDates(
            Long doctorId,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<Appointment> filterAppointmentsByAnimalIdAndTwoDates(
            Long animalId,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<AppointmentResponse> filterAppointmentResponsesByAnimalIdAndTwoDates(
            Long animalId,
            LocalDate startDate,
            LocalDate finishDate
    );
}
