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
@Table(name = "CustomerDetails")
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int userId;

	@Column(name = "Name")
	private String name;

	@Column(name = "cont_Number")
	private String contactNumber;

	@Column(name = "mail_Id")
	private String mail;

	@Column(name = "Address1")
	private String Address1;
	
	@Column(name = "Address2")
	private String Address2;

	@Column(name = "Address3")
	private String Address3;

	@Column(name = "City")
	private String city;

	@Column(name = "Pincode")
	private String pincode;
	
	@JsonIgnore
	@OneToMany(
			mappedBy="customerDetails", fetch = FetchType.LAZY)
	private List<BookLendDetails> bookLend;


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getAddress1() {
		return Address1;
	}


	public void setAddress1(String address1) {
		Address1 = address1;
	}


	public String getAddress2() {
		return Address2;
	}


	public void setAddress2(String address2) {
		Address2 = address2;
	}


	public String getAddress3() {
		return Address3;
	}


	public void setAddress3(String address3) {
		Address3 = address3;
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



	public List<BookLendDetails> getBookLend() {
		return bookLend;
	}
//
//
	public void setBookLend(List<BookLendDetails> bookLend) {
		this.bookLend = bookLend;
	}
//	
	
}
