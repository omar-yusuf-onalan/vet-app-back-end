package com.omaryusufonalan.vetappbackend.service.filter;

import com.omaryusufonalan.vetappbackend.dto.response.AnimalResponse;

import java.util.List;

public interface FilterAnimal {
    List<AnimalResponse> filterAnimalResponsesByName(String animalName);
    List<AnimalResponse> getAnimalResponsesByCustomerName(String customerName);
}
