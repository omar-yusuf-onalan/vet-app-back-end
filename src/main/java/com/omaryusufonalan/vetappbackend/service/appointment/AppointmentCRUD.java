package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Appointment;

import java.util.List;

public interface AppointmentCRUD {
    List<Appointment> getAllAppointments();
    List<AppointmentResponse> getAllAppointmentResponses();
    Appointment getAppointmentById(Long id);
    AppointmentResponse getAppointmentResponseById(Long id);
    AppointmentResponse createAppointment(AppointmentCreateRequest appointmentCreateRequest);
    AppointmentResponse updateAppointment(AppointmentUpdateRequest appointmentUpdateRequest);
    void deleteAppointmentById(Long id);
}
