package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper
public interface AppointmentMapper {
    Appointment asAppointment(AppointmentRequest appointmentRequest);

    AppointmentResponse asAppointmentResponse(Appointment appointment);

    Set<AppointmentResponse> asAppointmentResponses(Set<Appointment> appointment);

    void update(@MappingTarget Appointment appointment, AppointmentRequest appointmentRequest);
}
