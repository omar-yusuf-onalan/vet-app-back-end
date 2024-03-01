package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Customer;

public interface CustomerCRUD {
    Customer getCustomerById(Long id);
    CustomerResponse getCustomerResponseById(Long id);
    CustomerResponse createCustomer(CustomerCreateRequest customerCreateRequest);
    CustomerResponse updateCustomer(CustomerUpdateRequest customerUpdateRequest);
    void deleteCustomerById(Long id);
}
