package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorResponse;
import com.omaryusufonalan.vetappbackend.entity.Doctor;
import org.mapstruct.MappingTarget;

public interface DoctorMapper {
    Doctor asDoctor(DoctorRequest doctorRequest);

    DoctorResponse asDoctorResponse(Doctor doctor);

    void update(@MappingTarget Doctor doctor, DoctorRequest doctorRequest);
}
