package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Customer;

import java.util.List;

public interface CustomerCRUD {
    List<Customer> getAllCustomers();
    List<CustomerResponse> getAllCustomerResponses();
    Customer getCustomerById(Long id);
    CustomerResponse getCustomerResponseById(Long id);
    CustomerResponse createCustomer(CustomerCreateRequest customerCreateRequest);
    CustomerResponse updateCustomer(CustomerUpdateRequest customerUpdateRequest);
    void deleteCustomerById(Long id);
}
