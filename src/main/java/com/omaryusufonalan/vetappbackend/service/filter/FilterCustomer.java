package com.omaryusufonalan.vetappbackend.service.filter;

import com.omaryusufonalan.vetappbackend.dto.response.CustomerResponse;

import java.util.List;

public interface FilterCustomer {
    List<CustomerResponse> filterCustomerResponsesByName(String customerName);
}
