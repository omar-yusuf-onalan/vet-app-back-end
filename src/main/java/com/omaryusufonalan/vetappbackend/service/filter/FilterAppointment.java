package com.omaryusufonalan.vetappbackend.service.filter;

import com.omaryusufonalan.vetappbackend.dto.response.AppointmentResponse;

import java.time.LocalDate;
import java.util.List;

public interface FilterAppointment {
    List<AppointmentResponse> filterAppointmentResponsesByDoctorNameAndTwoDates(
            String doctorName,
            LocalDate startDate,
            LocalDate finishDate
    );
    List<AppointmentResponse> filterAppointmentResponsesByAnimalNameAndTwoDates(
            String animalName,
            LocalDate startDate,
            LocalDate finishDate
    );
}
