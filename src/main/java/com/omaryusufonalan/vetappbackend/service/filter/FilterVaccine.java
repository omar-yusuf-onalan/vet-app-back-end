package com.omaryusufonalan.vetappbackend.service.filter;

import com.omaryusufonalan.vetappbackend.dto.response.VaccineResponse;

import java.time.LocalDate;
import java.util.List;

public interface FilterVaccine {
    List<VaccineResponse> filterVaccineResponsesByAnimalName(String animalName);
    List<VaccineResponse> findAllVaccineResponsesBetweenTwoDates(LocalDate startDate, LocalDate finishDate);
}
