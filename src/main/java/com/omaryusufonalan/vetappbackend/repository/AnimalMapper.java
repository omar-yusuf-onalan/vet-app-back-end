package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalRequest;
import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper
public interface AnimalMapper {
    Animal asAnimal(AnimalRequest animalRequest);

    AnimalResponse asAnimalResponse(Animal animal);

    Set<AnimalResponse> asAnimalResponses(Set<Animal> animal);

    void update(@MappingTarget Animal animal, AnimalRequest animalRequest);
}
