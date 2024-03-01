package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.entity.Customer;

import java.util.List;

public interface FilterCustomer {
    List<Customer> filterCustomersByName(String customerName);
    List<CustomerResponse> filterCustomerResponsesByName(String customerName);
}
