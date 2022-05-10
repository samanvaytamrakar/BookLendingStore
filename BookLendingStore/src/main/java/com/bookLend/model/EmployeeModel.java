package com.bookLend.model;

import com.bookLend.entity.EmployeeDetails;

public class EmployeeModel {

	private String name;
		
	private String role;
		
	private String mail;
		
	private String address1;

	private String address2;

	private String address3;
		
	private String city;
		
	private String pincode;
	
	private String username;
		
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public EmployeeDetails toEntity() {
		EmployeeDetails emp = new EmployeeDetails();
		emp.setName(name);
		emp.setMail(mail);
		emp.setRole(role);
		emp.setAddress1(address1);
		emp.setAddress2(address2);
		emp.setAddress3(address3);
		emp.setCity(city);
		emp.setPincode(pincode);
		return emp;
	}

	@Override
	public String toString() {
		return "EmployeeModel [name=" + name + ", Role=" + role + ", mail=" + mail + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + ", city=" + city + ", pincode=" + pincode
				+ ", username=" + username + ", password=" + password + "]";
	}
		
	
	
}
