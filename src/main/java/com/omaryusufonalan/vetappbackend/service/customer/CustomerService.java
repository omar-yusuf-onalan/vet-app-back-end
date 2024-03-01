package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import com.omaryusufonalan.vetappbackend.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerCRUD {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID " + id + " not found!"));
    }

    @Override
    public CustomerResponse getCustomerResponseById(Long id) {
        return modelMapper.map(getCustomerById(id), CustomerResponse.class);
    }

    @Override
    public CustomerResponse createCustomer(CustomerCreateRequest customerCreateRequest) {
        Customer customerToBeCreated = modelMapper.map(customerCreateRequest, Customer.class);

        return modelMapper.map(customerRepository.save(customerToBeCreated), CustomerResponse.class);
    }

    @Override
    public CustomerResponse updateCustomer(CustomerUpdateRequest customerUpdateRequest) {
        Customer doesCustomerExist = getCustomerById(customerUpdateRequest.getId());

        modelMapper.map(customerUpdateRequest, doesCustomerExist);

        return modelMapper.map(customerRepository.save(doesCustomerExist), CustomerResponse.class);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.delete(getCustomerById(id));
    }
}
