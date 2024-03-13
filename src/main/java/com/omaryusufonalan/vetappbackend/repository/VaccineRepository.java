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
    @Query(value = "SELECT * FROM vaccine WHERE protection_finish_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Vaccine> findAllVaccinesBetweenTwoDates(LocalDate startDate, LocalDate finishDate);

    @Query(value = "SELECT vaccine.*" +
            " FROM vaccine" +
            " INNER JOIN animal ON vaccine.animal_id = animal.id" +
            " WHERE animal.name ILIKE %?1%", nativeQuery = true)
    List<Vaccine> findByAnimalName(String animalName);
}
