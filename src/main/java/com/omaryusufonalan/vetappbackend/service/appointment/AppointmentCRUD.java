package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Appointment;

public interface AppointmentCRUD {
    Appointment getAppointmentById(Long id);
    AppointmentResponse getAppointmentResponseById(Long id);
    AppointmentResponse createAppointment(AppointmentCreateRequest appointmentCreateRequest);
    AppointmentResponse updateAppointment(AppointmentUpdateRequest appointmentUpdateRequest);
    void deleteAppointmentById(Long id);
}
