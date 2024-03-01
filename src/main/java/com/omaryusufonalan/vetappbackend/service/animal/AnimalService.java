package com.omaryusufonalan.vetappbackend.service.animal;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.dto.animal.AnimalUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService implements AnimalCRUD {
    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    @Override
    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal with ID " + id + " not found!"));
    }

    @Override
    public AnimalResponse getAnimalResponseById(Long id) {
        return modelMapper.map(getAnimalById(id), AnimalResponse.class);
    }

    @Override
    public AnimalResponse createAnimal(AnimalCreateRequest animalCreateRequest) {
        Animal animalToBeCreated = modelMapper.map(animalCreateRequest, Animal.class);

        return modelMapper.map(animalRepository.save(animalToBeCreated), AnimalResponse.class);
    }

    @Override
    public AnimalResponse updateAnimal(AnimalUpdateRequest animalUpdateRequest) {
        Animal doesAnimalExist = getAnimalById(animalUpdateRequest.getId());

        modelMapper.map(animalUpdateRequest, doesAnimalExist);

        return modelMapper.map(animalRepository.save(doesAnimalExist), AnimalResponse.class);
    }

    @Override
    public void deleteAnimalById(Long id) {
        animalRepository.delete(getAnimalById(id));
    }
}
