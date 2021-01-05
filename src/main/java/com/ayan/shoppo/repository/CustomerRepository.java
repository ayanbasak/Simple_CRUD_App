package com.ayan.shoppo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayan.shoppo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
