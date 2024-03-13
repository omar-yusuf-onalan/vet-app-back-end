package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.core.ServiceTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.AnimalRequest;
import com.omaryusufonalan.vetappbackend.dto.response.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.mapper.AnimalMapper;
import com.omaryusufonalan.vetappbackend.repository.AnimalRepository;
import com.omaryusufonalan.vetappbackend.service.filter.FilterAnimal;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService implements ServiceTemplate<Animal, AnimalRequest, AnimalResponse>, FilterAnimal {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public List<AnimalResponse> getAll() {
        return animalMapper.entityToListResponse(animalRepository.findAll());
    }

    @Override
    public Animal getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal with ID " + id + " not found!"));
    }

    @Override
    public AnimalResponse getResponseById(Long id) {
        return animalMapper.entityToResponse(getById(id));
    }

    @Override
    public AnimalResponse create(AnimalRequest animalRequest) {
        return animalMapper.entityToResponse(
                animalRepository.save(
                        animalMapper.requestToEntity(animalRequest)
                )
        );
    }

    @Override
    public AnimalResponse update(Long id, AnimalRequest animalRequest) {
        Animal animalFromDb = getById(id);

        animalMapper.update(animalFromDb, animalRequest);

        return animalMapper.entityToResponse(animalRepository.save(animalFromDb));
    }

    @Override
    public void deleteById(Long id) {
        animalRepository.delete(getById(id));
    }

    @Override
    public List<AnimalResponse> filterAnimalResponsesByName(String animalName) {
        return animalMapper.entityToListResponse(animalRepository.findByNameIgnoringCaseContaining(animalName));
    }

    @Override
    public List<AnimalResponse> getAnimalResponsesByCustomerName(String customerName) {
        return animalMapper.entityToListResponse(animalRepository.findByCustomerName(customerName));
    }
}
