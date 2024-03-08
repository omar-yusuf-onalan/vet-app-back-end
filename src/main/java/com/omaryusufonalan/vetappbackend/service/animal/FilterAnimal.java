package com.omaryusufonalan.vetappbackend.service.animal;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;

import java.util.List;

public interface FilterAnimal {
    List<Animal> filterAnimalsByName(String animalName);
    List<AnimalResponse> filterAnimalResponsesByName(String animalName);
    List<Animal> getAnimalsByCustomerName(String customerName);
    List<AnimalResponse> getAnimalResponsesByCustomerName(String customerName);
}
