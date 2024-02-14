package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorResponse;
import com.omaryusufonalan.vetappbackend.entity.Doctor;
import com.omaryusufonalan.vetappbackend.mapper.DoctorMapper;
import com.omaryusufonalan.vetappbackend.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService implements GenericCRUD<Doctor, DoctorRequest, DoctorResponse> {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor with ID " + id + " not found"));
    }

    @Override
    public DoctorResponse getResponseById(Long id) {
        Doctor doctorRetrievedFromDatabase = getById(id);

        return doctorMapper.asDoctorResponse(doctorRetrievedFromDatabase);
    }

    @Override
    public DoctorResponse create(DoctorRequest doctorRequest) {
        Doctor doctorToBeCreated = doctorMapper.asDoctor(doctorRequest);

        Doctor copyReturnedFromDatabase = doctorRepository.save(doctorToBeCreated);

        return doctorMapper.asDoctorResponse(copyReturnedFromDatabase);
    }

    @Override
    public DoctorResponse update(Long id, DoctorRequest doctorRequest) {
        Doctor doctorToBeUpdated = getById(id);

        doctorMapper.update(doctorToBeUpdated, doctorRequest);

        Doctor copyReturnedFromTheDatabase = doctorRepository.save(doctorToBeUpdated);

        return doctorMapper.asDoctorResponse(copyReturnedFromTheDatabase);
    }

    @Override
    public void delete(Long id) {
        Doctor doctorToBeDeleted = getById(id);

        doctorRepository.delete(doctorToBeDeleted);
    }
}
