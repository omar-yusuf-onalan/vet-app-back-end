package com.omaryusufonalan.vetappbackend.service.vaccine;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;

import java.util.List;

public interface VaccinePage {
    List<Vaccine> getVaccinePage(int page, int pageSize);
    List<VaccineResponse> getVaccineResponsePage(int page, int pageSize);
}
