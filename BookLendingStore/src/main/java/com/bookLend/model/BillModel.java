package com.bookLend.model;

import java.util.Date;
import java.util.List;

public class BillModel {

	public String billNo;
	
	public String libraryMail;
	public String libraryContact;
	
	//libery name
	public String header1;
	public String header2;
	
	public String custName;
	public String custMail;
	public String custContact;
	public String issuedBy;
	
	public List<String> book;
	public List<Date> issue;
	public List<Date> returndate;
	public List<Double> cost;
	
	public double fine;
	public double total;
	
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getLibraryMail() {
		return libraryMail;
	}
	public void setLibraryMail(String libraryMail) {
		this.libraryMail = libraryMail;
	}
	public String getLibraryContact() {
		return libraryContact;
	}
	public void setLibraryContact(String libraryContact) {
		this.libraryContact = libraryContact;
	}
	public String getHeader1() {
		return header1;
	}
	public void setHeader1(String header1) {
		this.header1 = header1;
	}
	public String getHeader2() {
		return header2;
	}
	public void setHeader2(String header2) {
		this.header2 = header2;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustMail() {
		return custMail;
	}
	public void setCustMail(String custMail) {
		this.custMail = custMail;
	}
	public String getCustContact() {
		return custContact;
	}
	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	public List<String> getBook() {
		return book;
	}
	public void setBook(List<String> book) {
		this.book = book;
	}
	public List<Date> getIssue() {
		return issue;
	}
	public void setIssue(List<Date> issue) {
		this.issue = issue;
	}
	public List<Date> getReturndate() {
		return returndate;
	}
	public void setReturndate(List<Date> returndate) {
		this.returndate = returndate;
	}
	public List<Double> getCost() {
		return cost;
	}
	public void setCost(List<Double> cost) {
		this.cost = cost;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
