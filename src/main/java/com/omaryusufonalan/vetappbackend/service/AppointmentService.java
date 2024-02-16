package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.page.PageResponse;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.exception.AppointmentHourConflictException;
import com.omaryusufonalan.vetappbackend.exception.DoctorNotAvailableException;
import com.omaryusufonalan.vetappbackend.mapper.AppointmentMapper;
import com.omaryusufonalan.vetappbackend.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService implements GenericCRUD<Appointment, AppointmentRequest, AppointmentResponse> {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateService;
    private final PageService<AppointmentResponse> pageService;

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
    public PageResponse<AppointmentResponse> getPageResponse(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Appointment> pageOfAppointments = appointmentRepository.findAll(pageable);

        Page<AppointmentResponse> pageOfAppointmentResponses = pageOfAppointments
                .map(appointment -> appointmentMapper.asAppointmentResponse(appointment));

        return pageService.createPageResponse(page, pageSize, pageOfAppointmentResponses);
    }

    @Override
    public AppointmentResponse create(AppointmentRequest appointmentRequest) {
        checkValidityOf(appointmentRequest);

        Appointment appointmentToBeCreated = appointmentMapper.asAppointment(appointmentRequest);

        Appointment copyReturnedFromDatabase = appointmentRepository.save(appointmentToBeCreated);

        return appointmentMapper.asAppointmentResponse(copyReturnedFromDatabase);
    }

    private void checkValidityOf(AppointmentRequest appointmentRequest) {
        isADoctorAvailableOnThatDate(appointmentRequest);
        isThereAnHourConflictPresent(appointmentRequest);
    }

    private void isADoctorAvailableOnThatDate(AppointmentRequest appointmentRequest) {
        Long doctorId = appointmentRequest.getDoctor().getId();
        LocalDate date = appointmentRequest.getAppointmentDate().toLocalDate();

        Optional<AvailableDate> doctorMayHaveAnAvailableDate = availableDateService.getByDoctorIdAndAvailableDate(
                doctorId,
                date
        );

        if (doctorMayHaveAnAvailableDate.isEmpty()) {
            throw new DoctorNotAvailableException("Doctor with ID " + doctorId + " is not available on " + date);
        }
    }

    private void isThereAnHourConflictPresent(AppointmentRequest appointmentRequest) {
        Long doctorId = appointmentRequest.getDoctor().getId();
        LocalDateTime appointment = appointmentRequest.getAppointmentDate();

        Optional<Appointment> hourConflictMayBePresent = appointmentRepository.checkForConflictingAppointmentHours(
                doctorId,
                appointment
        );

        if (hourConflictMayBePresent.isPresent())
            throw new AppointmentHourConflictException("Hour conflict present at " + appointment);
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
