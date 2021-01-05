package com.ayan.shoppo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@NotBlank(message = "Please enter your Phone Number")
	private int phoneNo;
	@Size(min = 2, max = 5, message = "Please use 2 to 5 characters")
	private String nationality;
//	@NotBlank(message="Please enter your Address")
	private String CustomerAddress;
	private String customerImage;

	public Customer() {

	}

	public Customer(Long id, int phoneNo, String nationality, String customerAddress, String customerImage) {
		this.id = id;
		this.phoneNo = phoneNo;
		this.nationality = nationality;
		CustomerAddress = customerAddress;
		this.customerImage = customerImage;
	}

	public Customer(int phoneNo, String nationality, String customerAddress, String customerImage) {
		this.phoneNo = phoneNo;
		this.nationality = nationality;
		CustomerAddress = customerAddress;
		this.customerImage = customerImage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public String getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", phoneNo=" + phoneNo + ", nationality=" + nationality + ", CustomerAddress="
				+ CustomerAddress + ", customerImage=" + customerImage + "]";
	}

}
