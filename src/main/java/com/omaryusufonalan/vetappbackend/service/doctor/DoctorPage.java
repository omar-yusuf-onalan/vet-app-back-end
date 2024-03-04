package com.omaryusufonalan.vetappbackend.service.doctor;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorResponse;
import com.omaryusufonalan.vetappbackend.entity.Doctor;

import java.util.List;

public interface DoctorPage {
    List<Doctor> getDoctorPage(int page, int pageSize);
    List<DoctorResponse> getDoctorResponsePage(int page, int pageSize);
}
