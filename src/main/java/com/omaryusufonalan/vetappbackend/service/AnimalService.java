package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalRequest;
import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.dto.page.PageResponse;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineWithoutAnythingResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import com.omaryusufonalan.vetappbackend.mapper.AnimalMapper;
import com.omaryusufonalan.vetappbackend.repository.AnimalRepository;
import com.omaryusufonalan.vetappbackend.service.interfaces.FilterOperation;
import com.omaryusufonalan.vetappbackend.service.interfaces.GenericCRUD;
import com.omaryusufonalan.vetappbackend.service.interfaces.GetAdministeredVaccines;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AnimalService implements
        GenericCRUD<Animal, AnimalRequest, AnimalResponse>,
        FilterOperation<Animal, AnimalResponse>,
        GetAdministeredVaccines {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;
    private final PageService<AnimalResponse> pageService;

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
    public PageResponse<AnimalResponse> getPageResponse(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Animal> pageOfAnimals = animalRepository.findAll(pageable);

        Page<AnimalResponse> pageOfAnimalResponses = pageOfAnimals
                .map(animal -> animalMapper.asAnimalResponse(animal));

        return pageService.createPageResponse(page, pageSize, pageOfAnimalResponses);
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

    @Override
    public Animal filterByName(String name) {
        return animalRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public AnimalResponse filterResponseByName(String name) {
        Animal animalRetrievedFromDatabase = animalRepository.findByNameIgnoreCaseContaining(name);

        return animalMapper.asAnimalResponse(animalRetrievedFromDatabase);
    }

    @Override
    public Set<Vaccine> getAllAdministeredVaccines(Long id) {
        return getById(id).getVaccines();
    }

    @Override
    public Set<VaccineWithoutAnythingResponse> getAllAdministeredVaccineWithoutAnythingResponses(Long id) {
        return animalMapper.asAnimalResponse(getById(id)).getVaccines();
    }
}
