package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.CustomerRequest;
import com.omaryusufonalan.vetappbackend.dto.response.CustomerResponse;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper extends MapperTemplate<Customer, CustomerRequest, CustomerResponse> {
}
