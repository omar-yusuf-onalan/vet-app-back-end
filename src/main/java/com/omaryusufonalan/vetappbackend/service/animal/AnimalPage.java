package com.omaryusufonalan.vetappbackend.service.animal;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;

import java.util.List;

public interface AnimalPage {
    List<Animal> getAnimalPage(int page, int pageSize);
    List<AnimalResponse> getAnimalResponsePage(int page, int pageSize);
}
