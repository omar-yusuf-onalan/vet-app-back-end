package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(value = "SELECT * FROM appointments WHERE doctor_id = ?1 AND appointment_date = ?2", nativeQuery = true)
    Optional<Appointment> checkForConflictingAppointmentHours(Long doctorId, LocalDateTime appointment);
}
