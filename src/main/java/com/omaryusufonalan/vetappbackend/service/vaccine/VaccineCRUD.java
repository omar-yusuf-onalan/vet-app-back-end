package com.omaryusufonalan.vetappbackend.service.vaccine;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;

import java.util.List;

public interface VaccineCRUD {
    List<Vaccine> getAllVaccines();
    List<VaccineResponse> getAllVaccineResponses();
    Vaccine getVaccineById(Long id);
    VaccineResponse getVaccineResponseById(Long id);
    VaccineResponse createVaccine(VaccineCreateRequest vaccineCreateRequest);
    VaccineResponse updateVaccine(VaccineUpdateRequest vaccineUpdateRequest);
    void deleteVaccineById(Long id);
}
