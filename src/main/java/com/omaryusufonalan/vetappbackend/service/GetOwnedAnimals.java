package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;

import java.util.Set;

public interface GetOwnedAnimals {
    Set<Animal> getAllOwnedAnimals(Long id);

    Set<AnimalResponse> getAllOwnedAnimalResponses(Long id);
}
