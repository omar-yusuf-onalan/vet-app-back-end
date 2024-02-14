package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerRequest;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import com.omaryusufonalan.vetappbackend.mapper.CustomerMapper;
import com.omaryusufonalan.vetappbackend.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements GenericCRUD<Customer, CustomerRequest, CustomerResponse> {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID " + id + " not found"));
    }

    @Override
    public CustomerResponse getResponseById(Long id) {
        Customer customerRetrievedFromDatabase = getById(id);

        return customerMapper.asCustomerResponse(customerRetrievedFromDatabase);
    }

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        Customer customerToBeCreated = customerMapper.asCustomer(customerRequest);

        Customer copyReturnedFromDatabase = customerRepository.save(customerToBeCreated);

        return customerMapper.asCustomerResponse(copyReturnedFromDatabase);
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest customerRequest) {
        Customer customerToBeUpdated = getById(id);

        customerMapper.update(customerToBeUpdated, customerRequest);

        Customer copyReturnedFromTheDatabase = customerRepository.save(customerToBeUpdated);

        return customerMapper.asCustomerResponse(copyReturnedFromTheDatabase);
    }

    @Override
    public void delete(Long id) {
        Customer customerToBeDeleted = getById(id);

        customerRepository.delete(customerToBeDeleted);
    }
}
