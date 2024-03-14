package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyAppointmentDTO;
import com.omaryusufonalan.vetappbackend.dto.request.ReportRequest;
import com.omaryusufonalan.vetappbackend.dto.response.ReportResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.entity.Report;
import org.mapstruct.Mapper;

@Mapper
public interface ReportMapper extends MapperTemplate<Report, ReportRequest, ReportResponse> {
    Appointment dtoToEntity(OnlyAppointmentDTO onlyAppointmentDTO);
}
