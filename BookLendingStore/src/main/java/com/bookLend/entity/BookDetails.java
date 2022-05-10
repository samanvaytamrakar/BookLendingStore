/**
 * 
 */
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

/**
 * @author saman
 *
 */
@Entity
@Table(name = "BookDetails")
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Book_id")
	private int bookDetailId;
	
	@Column(name = "Book_Name")
	private String bookName;

	@Column(name = "Publish_Year")
	private String yearOfPublish;

	@Column(name = "Publisher")
	private String publisher;

	@Column(name = "Auther")
	private String auther;

	@Column(name = "Count")
	private int bookCount;

	@Column(name = "Cost")
	private double cost;

	@Column(name = "Lending_Cost")
	private double lendingCost;

	
	public double getLendingCost() {
		return lendingCost;
	}

	public void setLendingCost(double lendingCost) {
		this.lendingCost = lendingCost;
	}

	@OneToMany(mappedBy = "bookDetails", fetch = FetchType.LAZY)
	private List<BookLendDetails> bookLend;

	public int getBookDetailId() {
		return bookDetailId;
	}

	public void setBookDetailId(int bookDetailId) {
		this.bookDetailId = bookDetailId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getYearOfPublish() {
		return yearOfPublish;
	}

	public void setYearOfPublish(String yearOfPublish) {
		this.yearOfPublish = yearOfPublish;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
//
	public List<BookLendDetails> getBookLend() {
		return bookLend;
	}
//
	public void setBookLend(List<BookLendDetails> bookLend) {
		this.bookLend = bookLend;
	}
	
	public void borrowed() {
		this.bookCount--;
	}
	
	public void returned() {
		this.bookCount++;
	}
}
