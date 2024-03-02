package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
