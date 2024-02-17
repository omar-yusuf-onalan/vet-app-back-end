package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalWithoutCustomerResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;

import java.util.Set;

public interface GetOwnedAnimals {
    Set<Animal> getAllOwnedAnimals(Long id);

    Set<AnimalWithoutCustomerResponse> getAllOwnedAnimalWithoutCustomerResponses(Long id);
}
