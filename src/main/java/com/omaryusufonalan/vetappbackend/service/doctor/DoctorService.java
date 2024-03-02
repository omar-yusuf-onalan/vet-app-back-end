package com.omaryusufonalan.vetappbackend.service.doctor;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorResponse;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Doctor;
import com.omaryusufonalan.vetappbackend.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService implements DoctorCRUD {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor with ID " + id + " not found!"));
    }

    @Override
    public DoctorResponse getDoctorResponseById(Long id) {
        return modelMapper.map(getDoctorById(id), DoctorResponse.class);
    }

    @Override
    public DoctorResponse createDoctor(DoctorCreateRequest doctorCreateRequest) {
        Doctor doctorToBeCreated = modelMapper.map(doctorCreateRequest, Doctor.class);

        return modelMapper.map(doctorRepository.save(doctorToBeCreated), DoctorResponse.class);
    }

    @Override
    public DoctorResponse updateDoctor(DoctorUpdateRequest doctorUpdateRequest) {
        Doctor doesDoctorExist = getDoctorById(doctorUpdateRequest.getId());

        modelMapper.map(doctorUpdateRequest, doesDoctorExist);

        return modelMapper.map(doctorRepository.save(doesDoctorExist), DoctorResponse.class);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.delete(getDoctorById(id));
    }
}