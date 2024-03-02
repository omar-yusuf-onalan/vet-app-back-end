package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;

import java.util.List;

public interface GetAnimal {
    List<Animal> getCustomerAnimals(Long id);
    List<AnimalResponse> getCustomerAnimalResponses(Long id);
}
