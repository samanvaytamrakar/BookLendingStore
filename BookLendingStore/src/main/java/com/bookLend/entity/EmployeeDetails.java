package com.bookLend.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Emp_Id")
	private int empId;

	@Column(name = "Name")
	private String name;
	
	@Column(name = "Role")	
	private String Role;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "address_Line1")
	private String address1;

	@Column(name = "address_Line2")
	private String address2;

	@Column(name = "address_Line3")
	private String address3;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "Pincode")
	private String pincode;
	
	@JsonIgnore
	@OneToMany(
			mappedBy = "employeeDetails", fetch = FetchType.LAZY)
	private List<BookLendDetails> booklend;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
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

	public List<BookLendDetails> getBooklend() {
		return booklend;
	}

	public void setBooklend(List<BookLendDetails> booklend) {
		this.booklend = booklend;
	}
	
	
	
}
