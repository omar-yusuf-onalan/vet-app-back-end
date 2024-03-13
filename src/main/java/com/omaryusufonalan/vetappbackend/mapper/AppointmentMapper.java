package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.AppointmentRequest;
import com.omaryusufonalan.vetappbackend.dto.response.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentMapper extends MapperTemplate<Appointment, AppointmentRequest, AppointmentResponse> {
}
