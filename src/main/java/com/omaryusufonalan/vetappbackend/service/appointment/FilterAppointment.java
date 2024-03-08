package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface FilterAppointment {
    List<Appointment> filterAppointmentsByDoctorNameAndTwoDates(
            String doctorName,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<AppointmentResponse> filterAppointmentResponsesByDoctorNameAndTwoDates(
            String doctorName,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<Appointment> filterAppointmentsByAnimalNameAndTwoDates(
            String animalName,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<AppointmentResponse> filterAppointmentResponsesByAnimalNameAndTwoDates(
            String animalName,
            LocalDate startDate,
            LocalDate finishDate
    );
}
