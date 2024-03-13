package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.DoctorRequest;
import com.omaryusufonalan.vetappbackend.dto.response.DoctorResponse;
import com.omaryusufonalan.vetappbackend.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper extends MapperTemplate<Doctor, DoctorRequest, DoctorResponse> {
}
