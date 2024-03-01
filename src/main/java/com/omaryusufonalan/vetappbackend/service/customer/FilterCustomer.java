package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.entity.Customer;

import java.util.List;

public interface FilterCustomer {
    List<Customer> filterCustomerByName(String customerName);
    List<Customer> filterCustomerResponseByName(String customerName);
}
