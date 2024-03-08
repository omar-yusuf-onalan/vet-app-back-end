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
    @Query(value = "SELECT appointment.*" +
            " FROM appointment" +
            " INNER JOIN doctor ON appointment.doctor_id = doctor.id" +
            " WHERE doctor.name ILIKE %?1%" +
            " AND" +
            " appointment.appointment_date BETWEEN ?2 AND ?3",
            nativeQuery = true)
    List<Appointment> findByDoctorNameAndTwoDates(String doctorName, LocalDate startDate, LocalDate finishDate);
    @Query(value = "SELECT appointment.*" +
            " FROM appointment" +
            " INNER JOIN animal ON appointment.animal_id = animal.id" +
            " WHERE animal.name ILIKE %?1%" +
            " AND" +
            " appointment.appointment_date BETWEEN ?2 AND ?3",
            nativeQuery = true)
    List<Appointment> findByAnimalNameAndTwoDates(String animalName, LocalDate startDate, LocalDate finishDate);
}
