package com.ayan.shoppo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayan.shoppo.entity.Customer;
import com.ayan.shoppo.service.CustomerService;
import com.ayan.shoppo.validation.ValidationErrorsService;

@RestController
@RequestMapping("/customer")
//@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService service;

	@Autowired
	private ValidationErrorsService validationErrorsService;

	@GetMapping("/all")
	public Iterable<Customer> all() {
		return service.findAll();
	}

	@PostMapping("add")
	public ResponseEntity<?> createNewCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
		ResponseEntity<?> errorMap = validationErrorsService.ValidationErrorsFind(result);
		if (errorMap != null)
			return errorMap;

		Customer newEntity = service.save(customer);
		return new ResponseEntity<Customer>(newEntity, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
		Customer customer = service.findById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity<String>("Customer " + id + " deleted successfully", HttpStatus.OK);
	}

}
