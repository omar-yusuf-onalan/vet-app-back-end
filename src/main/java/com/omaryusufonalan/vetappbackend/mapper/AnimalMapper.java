package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyCustomerDTO;
import com.omaryusufonalan.vetappbackend.dto.request.AnimalRequest;
import com.omaryusufonalan.vetappbackend.dto.response.AnimalResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface AnimalMapper extends MapperTemplate<Animal, AnimalRequest, AnimalResponse> {
    Customer dtoToEntity(OnlyCustomerDTO customerDTO);
}
