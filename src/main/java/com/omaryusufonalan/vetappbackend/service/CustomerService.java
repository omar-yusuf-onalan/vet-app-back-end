package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.core.ServiceTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.CustomerRequest;
import com.omaryusufonalan.vetappbackend.dto.response.CustomerResponse;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import com.omaryusufonalan.vetappbackend.mapper.CustomerMapper;
import com.omaryusufonalan.vetappbackend.repository.CustomerRepository;
import com.omaryusufonalan.vetappbackend.service.filter.FilterCustomer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements 
        ServiceTemplate<Customer, CustomerRequest, CustomerResponse>,
        FilterCustomer {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> getAll() {
        return customerMapper.entityToListResponse(customerRepository.findAll());
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID " + id + " not found!"));
    }

    @Override
    public CustomerResponse getResponseById(Long id) {
        return customerMapper.entityToResponse(getById(id));
    }

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        return customerMapper.entityToResponse(
                customerRepository.save(
                        customerMapper.requestToEntity(customerRequest)
                )
        );
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest customerRequest) {
        Customer customerFromDb = getById(id);

        customerMapper.update(customerFromDb, customerRequest);

        return customerMapper.entityToResponse(customerRepository.save(customerFromDb));
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.delete(getById(id));
    }

    @Override
    public List<CustomerResponse> filterCustomerResponsesByName(String customerName) {
        return customerMapper.entityToListResponse(customerRepository.findByNameIgnoringCaseContaining(customerName));
    }
}
