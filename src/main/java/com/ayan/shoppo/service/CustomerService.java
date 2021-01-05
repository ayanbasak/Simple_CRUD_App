package com.ayan.shoppo.service;

import java.util.List;

import com.ayan.shoppo.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(Long theId);

	public Customer save(Customer theCustomer);

	public void deleteById(Long theId);
}
