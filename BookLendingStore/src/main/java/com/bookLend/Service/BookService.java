/**
 * 
 */
package com.bookLend.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookLend.entity.BookDetails;
import com.bookLend.entity.BookLendDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.BookLendModel;

/**
 * @author saman
 *
 */


public interface BookService {

	public BookDetails saveBook(BookDetails book);	
	
	public List<BookDetails> saveListOfBook(List<BookDetails> booklist);
	
	public List<BookDetails> fetchAllBooks();
	
	public BookDetails findBookById(int id);
	
	public List<BookDetails> findBookByAuthor(String author);
	
	public List<BookDetails> findBookByPublisher(String publisher);
	
	public String deleteBookById(int id);
	
	public String deleteBooksOfPublisher(String publisher);
	
	public String deleteBooksofAuther(String auther);
	
	public BookDetails updateBookLendingCost(int bookId, double lendingCost) throws BookLendException;
	
	public BookLendDetails issueBook(BookLendModel bookModel) throws BookLendException;
	
	public List<BookLendDetails> listAllBookLendDetails();

	public List<BookLendDetails> listAllReturnedBookInGivenDate(Date date);
	
	public List<BookLendDetails> findAllIssuedBooksByBookId(int bookId);
	
	public List<BookLendDetails> findAllIssuedBooksByCustomerId(int custId);
	
	public List<BookLendDetails> findAllIssuedBooksInGivenDate(Date date);
	
	public BookLendDetails returnBook(int issueBook) throws BookLendException;
	
	public List<BookLendDetails> findAllIssuedBooksInGivenTime(Date start,Date end);
	
	public List<BookLendDetails> findAllReturnedBooksInGivenTime(Date start,Date end);
		
		

}
