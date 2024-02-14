package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalRequest;
import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.mapper.AnimalMapper;
import com.omaryusufonalan.vetappbackend.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService implements GenericCRUD<Animal, AnimalRequest, AnimalResponse> {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public Animal getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal with ID " + id + " not found"));
    }

    @Override
    public AnimalResponse getResponseById(Long id) {
        Animal animalRetrievedFromDatabase = getById(id);

        return animalMapper.asAnimalResponse(animalRetrievedFromDatabase);
    }

    @Override
    public AnimalResponse create(AnimalRequest animalRequest) {
        Animal animalToBeCreated = animalMapper.asAnimal(animalRequest);

        Animal copyReturnedFromDatabase = animalRepository.save(animalToBeCreated);

        return animalMapper.asAnimalResponse(copyReturnedFromDatabase);
    }

    @Override
    public AnimalResponse update(Long id, AnimalRequest animalRequest) {
        Animal animalToBeUpdated = getById(id);

        animalMapper.update(animalToBeUpdated, animalRequest);

        Animal copyReturnedFromTheDatabase = animalRepository.save(animalToBeUpdated);

        return animalMapper.asAnimalResponse(copyReturnedFromTheDatabase);
    }

    @Override
    public void delete(Long id) {
        Animal animalToBeDeleted = getById(id);

        animalRepository.delete(animalToBeDeleted);
    }
}
