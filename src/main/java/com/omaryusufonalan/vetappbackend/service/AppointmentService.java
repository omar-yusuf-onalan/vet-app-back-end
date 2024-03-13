package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.core.ServiceTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.AppointmentRequest;
import com.omaryusufonalan.vetappbackend.dto.response.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.exception.AppointmentHourConflictException;
import com.omaryusufonalan.vetappbackend.mapper.AppointmentMapper;
import com.omaryusufonalan.vetappbackend.repository.AppointmentRepository;
import com.omaryusufonalan.vetappbackend.service.filter.FilterAppointment;
import com.omaryusufonalan.vetappbackend.service.validate.ValidateAppointment;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService implements
        ServiceTemplate<Appointment, AppointmentRequest, AppointmentResponse>,
        ValidateAppointment,
        FilterAppointment {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateService;

    @Override
    public List<AppointmentResponse> getAll() {
        return appointmentMapper.entityToListResponse(appointmentRepository.findAll());
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment with ID " + id + " not found!"));
    }

    @Override
    public AppointmentResponse getResponseById(Long id) {
        return appointmentMapper.entityToResponse(getById(id));
    }

    @Override
    public AppointmentResponse create(AppointmentRequest appointmentRequest) {
        return appointmentMapper.entityToResponse(
                appointmentRepository.save(
                        appointmentMapper.requestToEntity(appointmentRequest)
                )
        );
    }

    @Override
    public AppointmentResponse update(Long id, AppointmentRequest appointmentRequest) {
        Appointment appointmentFromDb = getById(id);

        appointmentMapper.update(appointmentFromDb, appointmentRequest);

        return appointmentMapper.entityToResponse(appointmentRepository.save(appointmentFromDb));
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.delete(getById(id));
    }

    @Override
    public void validateAppointment(Appointment appointment) {
        // check #1 Is doctor available on the requested date?
        checkIfDoctorIsNotAvailable(appointment);

        // check #2 Is there an hour conflict present?
        checkIfThereIsAnHourConflict(appointment);
    }

    private void checkIfDoctorIsNotAvailable(Appointment appointment) {
        Long doctorId = appointment.getDoctor().getId();
        LocalDate appointmentDate = appointment.getAppointmentDate().toLocalDate();

        boolean doctorIsNotAvailable = availableDateService.filterAvailableDateResponsesByDoctorIdAndAvailableDate(
                doctorId,
                appointmentDate
                ).isEmpty();

        if (doctorIsNotAvailable)
            throw new RuntimeException("Doctor is not available at this date: " + appointmentDate);
    }

    private void checkIfThereIsAnHourConflict(Appointment appointment) {
        Long doctorId = appointment.getDoctor().getId();
        LocalDateTime appointmentDate = appointment.getAppointmentDate();

        boolean hourConflictIsPresent = appointmentRepository.findByDoctorIdAndAppointmentDate(
                doctorId,
                appointmentDate
                ).isPresent();

        if (hourConflictIsPresent)
            throw new AppointmentHourConflictException("Hour conflict is present at this hour: " + appointmentDate);
    }

    @Override
    public List<AppointmentResponse> filterAppointmentResponsesByDoctorNameAndTwoDates(
            String doctorName,
            LocalDate startDate,
            LocalDate finishDate
    ) {
        return appointmentMapper.entityToListResponse(
                appointmentRepository.findByDoctorNameAndTwoDates(doctorName, startDate, finishDate)
        );
    }

    @Override
    public List<AppointmentResponse> filterAppointmentResponsesByAnimalNameAndTwoDates(
            String animalName,
            LocalDate startDate,
            LocalDate finishDate
    ) {
        return appointmentMapper.entityToListResponse(
                appointmentRepository.findByAnimalNameAndTwoDates(animalName, startDate, finishDate)
        );
    }
}
