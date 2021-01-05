package com.ayan.shoppo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayan.shoppo.entity.Customer;
import com.ayan.shoppo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Transactional
	public List<Customer> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Customer findById(Long theId) {
		Optional<Customer> result = repository.findById(theId);

		Customer theCustomer = null;

		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
			throw new RuntimeException("Did not find Customer Id - " + theId);
		}
		return theCustomer;
	}

	@Transactional
	public Customer save(Customer theCustomer) {
		repository.save(theCustomer);
		return theCustomer;
	}

	@Transactional
	public void deleteById(Long theId) {
		repository.deleteById(theId);
	}

}
