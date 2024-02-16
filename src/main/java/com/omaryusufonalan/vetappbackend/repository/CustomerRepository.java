package com.omaryusufonalan.vetappbackend.repository;

import com.omaryusufonalan.vetappbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNameIgnoreCaseContaining(String name);
}
