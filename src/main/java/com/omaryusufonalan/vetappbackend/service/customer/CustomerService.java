package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.dto.animal.AnimalResponse;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.dto.customer.CustomerUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import com.omaryusufonalan.vetappbackend.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerCRUD, FilterCustomer, GetAnimal, CustomerPage {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerResponse> getAllCustomerResponses() {
        return getAllCustomers()
                .stream().map(customer -> modelMapper.map(customer, CustomerResponse.class))
                .toList();
    }

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

    @Override
    public List<Customer> filterCustomersByName(String customerName) {
        return customerRepository.findByNameIgnoringCaseContaining(customerName);
    }

    @Override
    public List<CustomerResponse> filterCustomerResponsesByName(String customerName) {
        return customerRepository.findByNameIgnoringCaseContaining(customerName)
                .stream().map(customer -> modelMapper.map(customer, CustomerResponse.class))
                .toList();
    }

    @Override
    public List<Animal> getCustomerAnimals(Long id) {
        return getCustomerById(id).getAnimals();
    }

    @Override
    public List<AnimalResponse> getCustomerAnimalResponses(Long id) {
        return getCustomerById(id).getAnimals()
                .stream().map(animal -> modelMapper.map(animal, AnimalResponse.class)).toList();
    }

    @Override
    public List<Customer> getCustomerPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Customer> customerPage = customerRepository.findAll(pageable);

        return customerPage.stream().toList();
    }

    @Override
    public List<CustomerResponse> getCustomerResponsePage(int page, int pageSize) {
        return getCustomerPage(page, pageSize)
                .stream().map(customer -> modelMapper.map(customer, CustomerResponse.class))
                .toList();
    }
}
