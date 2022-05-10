package com.bookLend.dao.Impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookLend.Repo.BookDetailsRepo;
import com.bookLend.Repo.BookLendDetailsRepo;
import com.bookLend.dao.BookDao;
import com.bookLend.entity.BookDetails;
import com.bookLend.entity.BookLendDetails;
import com.bookLend.exception.BookLendException;

@Component
public class BookDaoImpl implements BookDao {

	@Autowired
	BookLendDetailsRepo lendRepo;
	
	@Autowired
	BookDetailsRepo bookRepo;
	
	@Override
	public BookDetails addBook(BookDetails book) {
		
		return bookRepo.save(book);
	}

	@Override
	public List<BookDetails> addListOfBook(List<BookDetails> booklist) {
		
		return (List<BookDetails>) bookRepo.saveAll(booklist);
	}

	@Override
	public List<BookDetails> getAllBooks() {
		
		return (List<BookDetails>) bookRepo.findAll();
	}

	@Override
	public BookDetails findBookById(int id) {
		
		return bookRepo.findById(id).get();
	}

	@Override
	public List<BookDetails> findBookByAuthor(String author) {
		
		return bookRepo.getBookByAuthor(author);
	}

	@Override
	public List<BookDetails> findBookByPublisher(String publisher) {
		
		return bookRepo.getBookByPublisher(publisher);
	}

	@Override
	public String deleteBookById(int id) {
		bookRepo.deleteById(id);
		return "book deleteed";
	}

	@Override
	public String deleteListOfBooks(List<BookDetails> books) {
		bookRepo.deleteAll(books);
		return "book deleted";
	}

	@Override
	public BookDetails updateBookLendingCost(int bookId, double lendingCost) throws BookLendException {
		BookDetails book = bookRepo.findById(bookId).get();
		
		if(book == null) {
			throw new BookLendException("Book not found in Database");
		}
		
		book.setLendingCost(lendingCost);
		return bookRepo.save(book);
	}

	
	@Override
	public List<BookLendDetails> listAllLoanedBook() {		
		return (List<BookLendDetails>) lendRepo.findAll();
	}

	@Override
	public List<BookLendDetails> findAllIssuedBooksByBookId(int bookId) {
		
		return lendRepo.getIssuedBookByBookId(bookId);
	}

	@Override
	public List<BookLendDetails> findAllIssuedBooksByCustomerId(int custId) {
		
		return lendRepo.getIssuedBookByCustomeId(custId);
	}

	@Override
	public List<BookLendDetails> findAllIssuedBooksInGivenDate(Date date) {
		
		return lendRepo.getIssuedBookByDate(date);
	}
	
	@Override
	public List<BookLendDetails> findAllIssuedBooksInGivenTime(Date start,Date end){
		return lendRepo.getIssuedBooksByDates(start, end);
	}
	
	@Override
	public BookLendDetails returnBook(BookLendDetails book) {
		
		return lendRepo.save(book);
	}
	
	@Override
	public BookLendDetails issueBook(BookLendDetails book) {
		
		return lendRepo.save(book);
	}

	@Override
	public List<BookLendDetails> findAllReturnedBooksInGivenDate(Date date) {
		
		return lendRepo.getReturnBookByDate(date);
	}

	@Override
	public List<BookLendDetails> findAllReturnedBooksInGivenTime(Date start, Date end) {
		
		return lendRepo.getReturnBooksByDates(start, end);
	}
	
	@Override
	public List<BookLendDetails> findAllBookLendDetails(){
		return (List<BookLendDetails>) lendRepo.findAll();
	}

	public BookLendDetails getBookById(int id) {
		
		return lendRepo.findById(id).get();
	}

}
