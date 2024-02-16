package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;

import java.util.Set;

public interface GetAdministeredVaccines {
    Set<Vaccine> getAllAdministeredVaccines(Long id);

    Set<VaccineResponse> getAllAdministeredVaccineResponses(Long id);
}
