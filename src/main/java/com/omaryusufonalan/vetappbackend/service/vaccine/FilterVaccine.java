package com.omaryusufonalan.vetappbackend.service.vaccine;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;

import java.util.List;

public interface FilterVaccine {
    List<Vaccine> filterVaccinesByAnimalId(Long animalId);
    List<VaccineResponse> filterVaccineResponsesByAnimalId(Long animalId);
}
