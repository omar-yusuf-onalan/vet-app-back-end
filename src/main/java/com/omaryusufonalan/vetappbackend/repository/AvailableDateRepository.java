package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    Optional<AvailableDate> findByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate);
}
