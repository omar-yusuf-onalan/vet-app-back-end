package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;

import java.util.List;

public interface AppointmentPage {
    List<Appointment> getAppointmentPage(int page, int pageSize);
    List<AppointmentResponse> getAppointmentResponsePage(int page, int pageSize);
}
