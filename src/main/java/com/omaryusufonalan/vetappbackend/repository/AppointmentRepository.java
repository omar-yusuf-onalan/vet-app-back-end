package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);
}
