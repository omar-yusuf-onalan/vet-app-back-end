package com.omaryusufonalan.vetappbackend.service.appointment;

import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.dto.appointment.AppointmentUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.exception.AppointmentHourConflictException;
import com.omaryusufonalan.vetappbackend.repository.AppointmentRepository;
import com.omaryusufonalan.vetappbackend.service.availabledate.AvailableDateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService implements AppointmentCRUD, ValidateAppointment, FilterAppointment, AppointmentPage {
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;
    private final AvailableDateService availableDateService;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<AppointmentResponse> getAllAppointmentResponses() {
        return getAllAppointments()
                .stream().map(appointment -> modelMapper.map(appointment, AppointmentResponse.class))
                .toList();
    }

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

        validateAppointment(appointmentToBeCreated);

        return modelMapper.map(appointmentRepository.save(appointmentToBeCreated), AppointmentResponse.class);
    }

    @Override
    public AppointmentResponse updateAppointment(AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment doesAppointmentExist = getAppointmentById(appointmentUpdateRequest.getId());

        modelMapper.map(appointmentUpdateRequest, doesAppointmentExist);

        validateAppointment(doesAppointmentExist);

        return modelMapper.map(appointmentRepository.save(doesAppointmentExist), AppointmentResponse.class);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.delete(getAppointmentById(id));
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

        boolean doctorIsNotAvailable = availableDateService.filterAvailableDatesByDoctorIdAndAvailableDate(
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
    public List<Appointment> filterAppointmentsByDoctorNameAndTwoDates(String doctorName, LocalDate startDate, LocalDate finishDate) {
        return appointmentRepository.findByDoctorNameAndTwoDates(doctorName, startDate, finishDate);
    }

    @Override
    public List<AppointmentResponse> filterAppointmentResponsesByDoctorNameAndTwoDates(String doctorName, LocalDate startDate, LocalDate finishDate) {
        return appointmentRepository.findByDoctorNameAndTwoDates(doctorName, startDate, finishDate)
                .stream().map(appointment -> modelMapper.map(appointment, AppointmentResponse.class))
                .toList();
    }

    @Override
    public List<Appointment> filterAppointmentsByAnimalNameAndTwoDates(String animalName, LocalDate startDate, LocalDate finishDate) {
        return appointmentRepository.findByAnimalNameAndTwoDates(animalName, startDate, finishDate);
    }

    @Override
    public List<AppointmentResponse> filterAppointmentResponsesByAnimalNameAndTwoDates(String animalName, LocalDate startDate, LocalDate finishDate) {
        return appointmentRepository.findByAnimalNameAndTwoDates(animalName, startDate, finishDate)
                .stream().map(appointment -> modelMapper.map(appointment, AppointmentResponse.class))
                .toList();
    }

    @Override
    public List<Appointment> getAppointmentPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Appointment> appointmentPage = appointmentRepository.findAll(pageable);

        return appointmentPage.stream().toList();
    }

    @Override
    public List<AppointmentResponse> getAppointmentResponsePage(int page, int pageSize) {
        return getAppointmentPage(page, pageSize)
                .stream().map(appointment -> modelMapper.map(appointment, AppointmentResponse.class))
                .toList();
    }
}
