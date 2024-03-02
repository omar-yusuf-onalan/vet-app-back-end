package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.repository.AppointmentRepository;
import com.omaryusufonalan.vetappbackend.service.availabledate.AvailableDateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService implements AppointmentCRUD, ValidateAppointment {
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;
    private final AvailableDateService availableDateService;

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment with ID " + id + " not found!"));
    }

    @Override
    public AppointmentResponse getAppointmentResponseById(Long id) {
        return modelMapper.map(getAppointmentById(id), AppointmentResponse.class);
    }

    @Override
    public AppointmentResponse createAppointment(AppointmentCreateRequest appointmentCreateRequest) {
        Appointment appointmentToBeCreated = modelMapper.map(appointmentCreateRequest, Appointment.class);

        return modelMapper.map(appointmentRepository.save(appointmentToBeCreated), AppointmentResponse.class);
    }

    @Override
    public AppointmentResponse updateAppointment(AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment doesAppointmentExist = getAppointmentById(appointmentUpdateRequest.getId());

        modelMapper.map(appointmentUpdateRequest, doesAppointmentExist);

        return modelMapper.map(appointmentRepository.save(doesAppointmentExist), AppointmentResponse.class);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.delete(getAppointmentById(id));
    }

    @Override
    public void validateAppointment(Appointment appointment) {

    }
}
