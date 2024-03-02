package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    @Query(value = "SELECT * FROM vaccine WHERE code = ?1 AND protection_finish_date > ?2", nativeQuery = true)
    Optional<Vaccine> validateVaccine(String code, LocalDate protectionStartDate);
    List<Vaccine> findByAnimalId(Long animalId);
}
