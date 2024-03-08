package com.omaryusufonalan.vetappbackend.service.animal;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.dto.animal.AnimalUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Animal;

import java.util.List;

public interface AnimalCRUD {
    List<Animal> getAllAnimals();
    List<AnimalResponse> getAllAnimalResponses();
    Animal getAnimalById(Long id);
    AnimalResponse getAnimalResponseById(Long id);
    AnimalResponse createAnimal(AnimalCreateRequest animalCreateRequest);
    AnimalResponse updateAnimal(AnimalUpdateRequest animalUpdateRequest);
    void deleteAnimalById(Long id);
}
