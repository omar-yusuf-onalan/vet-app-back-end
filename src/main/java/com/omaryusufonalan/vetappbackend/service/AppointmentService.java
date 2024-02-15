package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.mapper.AppointmentMapper;
import com.omaryusufonalan.vetappbackend.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService implements GenericCRUD<Appointment, AppointmentRequest, AppointmentResponse> {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateService;

    @Override
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment with ID " + id + " not found"));
    }

    @Override
    public AppointmentResponse getResponseById(Long id) {
        Appointment appointmentRetrievedFromDatabase = getById(id);

        return appointmentMapper.asAppointmentResponse(appointmentRetrievedFromDatabase);
    }

    @Override
    public AppointmentResponse create(AppointmentRequest appointmentRequest) {
        // TODO: check if appointment is valid

        Appointment appointmentToBeCreated = appointmentMapper.asAppointment(appointmentRequest);

        Appointment copyReturnedFromDatabase = appointmentRepository.save(appointmentToBeCreated);

        return appointmentMapper.asAppointmentResponse(copyReturnedFromDatabase);
    }

    @Override
    public AppointmentResponse update(Long id, AppointmentRequest appointmentRequest) {
        Appointment appointmentToBeUpdated = getById(id);

        appointmentMapper.update(appointmentToBeUpdated, appointmentRequest);

        Appointment copyReturnedFromTheDatabase = appointmentRepository.save(appointmentToBeUpdated);

        return appointmentMapper.asAppointmentResponse(copyReturnedFromTheDatabase);
    }

    @Override
    public void delete(Long id) {
        Appointment appointmentToBeDeleted = getById(id);

        appointmentRepository.delete(appointmentToBeDeleted);
    }
}
