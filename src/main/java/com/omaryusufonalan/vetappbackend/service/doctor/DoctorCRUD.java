package com.omaryusufonalan.vetappbackend.service.doctor;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorResponse;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Doctor;

public interface DoctorCRUD {
    Doctor getDoctorById(Long id);
    DoctorResponse getDoctorResponseById(Long id);
    DoctorResponse createDoctor(DoctorCreateRequest doctorCreateRequest);
    DoctorResponse updateDoctor(DoctorUpdateRequest doctorUpdateRequest);
    void deleteDoctorById(Long id);
}
