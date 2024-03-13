package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.core.ServiceTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.DoctorRequest;
import com.omaryusufonalan.vetappbackend.dto.response.DoctorResponse;
import com.omaryusufonalan.vetappbackend.entity.Doctor;
import com.omaryusufonalan.vetappbackend.mapper.DoctorMapper;
import com.omaryusufonalan.vetappbackend.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService implements ServiceTemplate<Doctor, DoctorRequest, DoctorResponse> {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> getAll() {
        return doctorMapper.entityToListResponse(doctorRepository.findAll());
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor with ID " + id + " not found!"));
    }

    @Override
    public DoctorResponse getResponseById(Long id) {
        return doctorMapper.entityToResponse(getById(id));
    }

    @Override
    public DoctorResponse create(DoctorRequest doctorRequest) {
        return doctorMapper.entityToResponse(
                doctorRepository.save(
                        doctorMapper.requestToEntity(doctorRequest)
                )
        );
    }

    @Override
    public DoctorResponse update(Long id, DoctorRequest doctorRequest) {
        Doctor doctorFromDb = getById(id);

        doctorMapper.update(doctorFromDb, doctorRequest);

        return doctorMapper.entityToResponse(doctorRepository.save(doctorFromDb));
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.delete(getById(id));
    }
}
