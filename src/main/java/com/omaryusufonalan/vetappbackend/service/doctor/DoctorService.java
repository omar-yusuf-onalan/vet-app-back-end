package com.omaryusufonalan.vetappbackend.service.doctor;

import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorResponse;
import com.omaryusufonalan.vetappbackend.dto.doctor.DoctorUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Doctor;
import com.omaryusufonalan.vetappbackend.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService implements DoctorCRUD, DoctorPage {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<DoctorResponse> getAllDoctorResponses() {
        return getAllDoctors()
                .stream().map(doctor -> modelMapper.map(doctor, DoctorResponse.class))
                .toList();
    }

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

    @Override
    public List<Doctor> getDoctorPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Doctor> doctorPage = doctorRepository.findAll(pageable);

        return doctorPage.stream().toList();
    }

    @Override
    public List<DoctorResponse> getDoctorResponsePage(int page, int pageSize) {
        return getDoctorPage(page, pageSize)
                .stream().map(doctor -> modelMapper.map(doctor, DoctorResponse.class))
                .toList();
    }
}
