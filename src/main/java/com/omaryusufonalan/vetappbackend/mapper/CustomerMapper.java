package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerRequest;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CustomerMapper {
    Customer asCustomer(CustomerRequest customerRequest);

    CustomerResponse asCustomerResponse(Customer customer);

    void update(@MappingTarget Customer customer, CustomerRequest customerRequest);
}
