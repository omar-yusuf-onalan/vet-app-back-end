package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.entity.Customer;

public interface FilterCustomer {
    Customer filterCustomerByName(String customerName);
    Customer filterCustomerResponseByName(String customerName);
}
