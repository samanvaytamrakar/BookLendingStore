package com.bookLend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Single_Book_Details")
public class SingleBookDetails {

	@Id
	public int id;

	public int bookid;
	
}
