package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);
    @Query(value = "SELECT * FROM appointment WHERE doctor_id = ?1 AND appointment_date BETWEEN ?2 AND ?3",
            nativeQuery = true)
    List<Appointment> findByDoctorIdAndTwoDates(Long doctorId, LocalDate startDate, LocalDate finishDate);
    @Query(value = "SELECT * FROM appointment WHERE animal_id = ?1 AND appointment_date BETWEEN ?2 AND ?3",
            nativeQuery = true)
    List<Appointment> findByAnimalIdAndTwoDates(Long animalId, LocalDate startDate, LocalDate finishDate);
}
