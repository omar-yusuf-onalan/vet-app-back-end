package com.omaryusufonalan.vetappbackend.service.customer;

import com.omaryusufonalan.vetappbackend.dto.customer.CustomerResponse;
import com.omaryusufonalan.vetappbackend.entity.Customer;

import java.util.List;

public interface CustomerPage {
    List<Customer> getCustomerPage(int page, int pageSize);
    List<CustomerResponse> getCustomerResponsePage(int page, int pageSize);
}
