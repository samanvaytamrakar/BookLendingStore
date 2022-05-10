package com.bookLend.Service.Impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookLend.Service.BookService;
import com.bookLend.dao.BookDao;
import com.bookLend.dao.CustomerDao;
import com.bookLend.dao.EmployeeDao;
import com.bookLend.entity.BookDetails;
import com.bookLend.entity.BookLendDetails;
import com.bookLend.entity.CustomerDetails;
import com.bookLend.entity.EmployeeDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.BookLendModel;
import com.bookLend.utility.DateUtility;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Autowired
	CustomerDao custDao;
	
	@Autowired
	EmployeeDao empDao;
	
	
	
	/**
	 * 
	 */
	@Override
	public BookDetails saveBook(BookDetails book) {
		
		return bookDao.addBook(book);
	}

	
	@Override
	public List<BookDetails> saveListOfBook(List<BookDetails> booklist) {
		
		return bookDao.addListOfBook(booklist);
	}

	/**
	 * 
	 */
	@Override
	public List<BookDetails> fetchAllBooks() {
		
		return bookDao.getAllBooks();
	}
	

	@Override
	public BookDetails findBookById(int id) {
		
		return bookDao.findBookById(id);
	}
	
	/**
	 * 
	 */
	@Override
	public List<BookDetails> findBookByAuthor(String author) {
		
		return bookDao.findBookByAuthor(author);
	}

	/**
	 * 
	 */
	@Override
	public List<BookDetails> findBookByPublisher(String publisher) {
		
		return bookDao.findBookByPublisher(publisher);
	}

	/**
	 * 
	 */
	@Override
	public String deleteBookById(int id) {
		
		return bookDao.deleteBookById(id);
	}

	/**
	 * 
	 */
	@Override
	public String deleteBooksOfPublisher(String publisher) {
	
		List<BookDetails> books = bookDao.findBookByPublisher(publisher);
		
		return bookDao.deleteListOfBooks(books);
	}

	/**
	 * 
	 */
	@Override
	public String deleteBooksofAuther(String auther) {

		List<BookDetails> books = bookDao.findBookByAuthor(auther);
		
		return bookDao.deleteListOfBooks(books);
	}

	@Override
	public BookDetails updateBookLendingCost(int bookId, double lendingCost) throws BookLendException {
		
		return bookDao.updateBookLendingCost(bookId, lendingCost);
	}
	
	
	/**
	 * @throws BookLendException 
	 * 
	 */
	@Override
	public BookLendDetails issueBook(BookLendModel bookModel) throws BookLendException {
		
		CustomerDetails customer = custDao.searchCustomer(bookModel.getCustomerId());
		BookDetails book = bookDao.findBookById(bookModel.getBookId());
		EmployeeDetails emp = empDao.findEmployeeById(bookModel.getEmpId());
		
		if(customer == null || book == null || emp == null) {
			throw new BookLendException("Details are not valid");
		}
		
		if(book.getBookCount() == 0) {
			System.out.println("Book is out of stock");
			throw new BookLendException("Book is out of stock");
		}
		
		BookLendDetails lendDetail = new BookLendDetails();
				
		
		try {
			lendDetail.setLendDate(DateUtility.getSQLformattedDate(DateUtility.formattedDate(bookModel.getLendDate(),"yyyy-MM-dd")));
			lendDetail.setReturnDate(DateUtility.getSQLformattedDate(
					DateUtility.formattedDate(bookModel.getReturnDate(),"yyyy-MM-dd")));
		}catch (ParseException e1) {
				System.out.println("catch");
				throw new BookLendException("Date format is not valid",e1);		
			}
		int day = 0;
		try {
			// day = DateUtility.getDaysBetweenDates(bookModel.getReturnDate(), bookModel.getLendDate());
			 day = DateUtility.getDaysBetweenDates(bookModel.getReturnDate(), bookModel.getLendDate());
		} 
		catch (ParseException e) {
			
			throw new BookLendException("Date format is not valid",e);	
		}
		
		lendDetail.setLendCost(book.getLendingCost()*day);
		lendDetail.setFine(0.00);
		lendDetail.setStatus(true);
		
		lendDetail.setUserId(customer);
		
		book.borrowed();
		lendDetail.setBookId(book);
		
		lendDetail.setEmpId(emp);
		
		
		return bookDao.issueBook(lendDetail);
	}

	
	@Override
	public List<BookLendDetails> listAllBookLendDetails() {
		
		return bookDao.findAllBookLendDetails();
	}

	/**
	 * 
	 */
	@Override
	public List<BookLendDetails> listAllReturnedBookInGivenDate(Date date) {
		
		return bookDao.findAllReturnedBooksInGivenDate(DateUtility.getSQLformattedDate(date));
	}

	@Override
	public List<BookLendDetails> findAllIssuedBooksByBookId(int bookId) {
		
		return bookDao.findAllIssuedBooksByBookId(bookId);
	}

	@Override
	public List<BookLendDetails> findAllIssuedBooksByCustomerId(int custId) {
		
		return bookDao.findAllIssuedBooksByCustomerId(custId);
	}

	/**
	 * 
	 */
	@Override
	public List<BookLendDetails> findAllIssuedBooksInGivenDate(Date date) {
		
		return bookDao.findAllIssuedBooksInGivenDate(DateUtility.getSQLformattedDate(date));
	}

	/**
	 * 
	 */
	@Override
	public List<BookLendDetails> findAllIssuedBooksInGivenTime(Date start, Date end) {
		
		return bookDao.findAllIssuedBooksInGivenTime(DateUtility.getSQLformattedDate(start), DateUtility.getSQLformattedDate(end));
	}

	/**
	 * 
	 */
	@Override
	public List<BookLendDetails> findAllReturnedBooksInGivenTime(Date start, Date end) {
		
		return bookDao.findAllReturnedBooksInGivenTime(DateUtility.getSQLformattedDate(start), DateUtility.getSQLformattedDate(end));
	}
	
	/**
	 * @throws BookLendException 
	 * 
	 */
	@Override
	public BookLendDetails returnBook(int issueBook) throws BookLendException {
		
		BookLendDetails booklend = bookDao.getBookById(issueBook);
		
		if(booklend == null ) {
			System.out.println("issue Id is not valid");
			throw new BookLendException("issue id is not valid");
		}
		
		Date issueDate = new Date(booklend.getLendDate().getTime());
		Date currentDate = DateUtility.returnCurrentDate();
		Date returnDate = new Date(booklend.getReturnDate().getTime());
		
		int extraDays=0;
		try {
			extraDays = DateUtility.getDaysBetweenDates(issueDate,currentDate);
		} 
		catch (ParseException e) {
				throw new BookLendException("Date format is not valid",e);
			
		}
		
		if(currentDate.compareTo(returnDate)>0) {
			double fine = 100;	
			double lendcost = fine + (booklend.getBookId().getLendingCost()*extraDays);
			booklend.setFine(fine);
			booklend.setLendCost(lendcost);
			booklend.setReturnDate(DateUtility.getSQLformattedDate(currentDate));
		}
		else if(returnDate.compareTo(currentDate)>0) {
			double lendcost =  (booklend.getBookId().getLendingCost()*extraDays);
			booklend.setLendCost(lendcost);
			booklend.setReturnDate(DateUtility.getSQLformattedDate(currentDate));
		}
		
		booklend.setStatus(false);
		booklend.getBookId().returned();
		
		return bookDao.returnBook(booklend);
	}

}
