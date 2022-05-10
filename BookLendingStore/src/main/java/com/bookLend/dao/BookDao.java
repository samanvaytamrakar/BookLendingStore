package com.bookLend.dao;

import java.sql.Date;
import java.util.List;

import com.bookLend.entity.BookDetails;
import com.bookLend.entity.BookLendDetails;
import com.bookLend.exception.BookLendException;


public interface BookDao {
	
		public BookDetails addBook(BookDetails book);	
		
		public List<BookDetails> addListOfBook(List<BookDetails> booklist);
		
		public List<BookDetails> getAllBooks();
		
		public BookDetails findBookById(int id);
		
		public List<BookDetails> findBookByAuthor(String author);
		
		public List<BookDetails> findBookByPublisher(String publisher);
		
		public String deleteBookById(int id);
		
		public String deleteListOfBooks(List<BookDetails> books);
		
		public BookDetails updateBookLendingCost(int bookId, double lendingCost) throws BookLendException;
		
		public BookLendDetails issueBook(BookLendDetails bookDto);
		
		public List<BookLendDetails> listAllLoanedBook();
		
		public List<BookLendDetails> findAllIssuedBooksByBookId(int bookId);
		
		public List<BookLendDetails> findAllIssuedBooksByCustomerId(int custId);
		
		public List<BookLendDetails> findAllIssuedBooksInGivenDate(Date date);
		
		public BookLendDetails returnBook(BookLendDetails book);
		
		public List<BookLendDetails> findAllIssuedBooksInGivenTime(Date start,Date end);
		
		public List<BookLendDetails> findAllReturnedBooksInGivenDate(Date date);
		
		public List<BookLendDetails> findAllReturnedBooksInGivenTime(Date start,Date end);
		
		public List<BookLendDetails> findAllBookLendDetails();
		public BookLendDetails getBookById(int id);
}
