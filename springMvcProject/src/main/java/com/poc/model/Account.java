package com.poc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Account {

	@Size(min=5,max=10)
	private String firstName;
	@Size(min=5,max=10)
	private String lastName;
	@Size(min=5,max=100)
	private String address;
	@Email
	private String email;
	@Override
	public String toString() {
		return "Account [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email="
				+ email + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
