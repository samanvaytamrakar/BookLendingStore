package com.bookLend.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookLendDetails")
public class BookLendDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Lend_ID")
	private int BookLendId;

	@Column(name = "Lend_Date")
	private Date lendDate;

	@Column(name = "Return_Date")
	private Date returnDate;

	@Column(name = "Lend_cost")
	private double lendCost;
	
	@Column(name = "fine")
	private double fine;

	@Column(name = "status")
	private boolean status;

	@ManyToOne(
			fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name ="userId")
	private CustomerDetails customerDetails;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "bookDetailId")
	private BookDetails bookDetails;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "Emp_id")
	private EmployeeDetails employeeDetails;

	public int getBookLendId() {
		return BookLendId;
	}

	public void setBookLendId(int bookLendId) {
		BookLendId = bookLendId;
	}

	public Date getLendDate() {
		return lendDate;
	}

	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getLendCost() {
		return lendCost;
	}

	public void setLendCost(double lendCost) {
		this.lendCost = lendCost;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CustomerDetails getUserId() {
		return customerDetails;
	}

	public void setUserId(CustomerDetails userId) {
		this.customerDetails = userId;
	}

	public BookDetails getBookId() {
		return bookDetails;
	}

	public void setBookId(BookDetails bookId) {
		this.bookDetails = bookId;
	}

	public EmployeeDetails getEmpId() {
		return employeeDetails;
	}

	public void setEmpId(EmployeeDetails empId) {
		this.employeeDetails = empId;
	}
	
	
	
	
	
}
