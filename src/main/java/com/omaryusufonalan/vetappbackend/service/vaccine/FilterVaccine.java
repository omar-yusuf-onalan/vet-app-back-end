package com.omaryusufonalan.vetappbackend.service.vaccine;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface FilterVaccine {
    List<Vaccine> filterVaccinesByAnimalId(Long animalId);
    List<VaccineResponse> filterVaccineResponsesByAnimalId(Long animalId);
    List<Vaccine> findAllVaccinesBetweenTwoDates(LocalDate startDate, LocalDate finishDate);
    List<VaccineResponse> findAllVaccineResponsesBetweenTwoDates(LocalDate startDate, LocalDate finishDate);
}
