package com.omaryusufonalan.vetappbackend.service.interfaces;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineWithoutAnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;

import java.util.Set;

public interface GetAdministeredVaccines {
    Set<Vaccine> getAllAdministeredVaccines(Long id);

    Set<VaccineWithoutAnimalResponse> getAllAdministeredVaccineWithoutAnimalResponses(Long id);
}
