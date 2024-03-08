package com.omaryusufonalan.vetappbackend.service.doctor;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorResponse;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Doctor;

import java.util.List;

public interface DoctorCRUD {
    List<Doctor> getAllDoctors();
    List<DoctorResponse> getAllDoctorResponses();
    Doctor getDoctorById(Long id);
    DoctorResponse getDoctorResponseById(Long id);
    DoctorResponse createDoctor(DoctorCreateRequest doctorCreateRequest);
    DoctorResponse updateDoctor(DoctorUpdateRequest doctorUpdateRequest);
    void deleteDoctorById(Long id);
}
