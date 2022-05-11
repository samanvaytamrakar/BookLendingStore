package com.bookLend.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookLend.Service.BookService;
import com.bookLend.entity.BookLendDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.BookLendModel;
import com.bookLend.model.BookLendResponse;
import com.bookLend.utility.DateUtility;
import com.bookLend.utility.constants.bookStoreConstants;

@RestController
@RequestMapping("/User/BookLendManagement")
//@CrossOrigin(origins = "http://localhost:4200")
public class BookLendController {


	@Autowired
	BookService bookService;
	
	
	@PostMapping(value= "/issueBook" )
	public BookLendResponse<List<BookLendDetails>> issueBook(@RequestBody List<BookLendModel> bookModels) throws BookLendException{
		
		if(bookModels== null || bookModels.size() == 0) {
			System.out.println("detail not found");
			return new BookLendResponse("Book details are null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);		
		}
		
		List<BookLendDetails> details = new ArrayList<BookLendDetails>();
		
		for(BookLendModel bookModel : bookModels ) {
			BookLendDetails lendDetail = bookService.issueBook(bookModel);
		
			if(lendDetail  == null) {
				throw new BookLendException(bookStoreConstants.PROCESSFAILD);
			}
			
			details.add(lendDetail);
		}
		
		BookLendResponse response = new BookLendResponse("Book Issued","200",HttpStatus.OK,details);
		
		return response;
	}
	

	@PostMapping(value= "/returnBook" )
	public BookLendResponse<List<BookLendDetails>> returnBook(@RequestParam("issueId") String issueId) throws BookLendException{

		if(issueId == null) {
			System.out.println("Id is null");
			throw new BookLendException("Id is null");		
		}
		
		String[] ids = issueId.split(",");
		List<Integer> issued = new ArrayList<>();
		
		//validating and converting id into integer
		for(String str : ids) {
		int id = 0;
		try {
			id = Integer.parseInt(str.trim());
			issued.add(id);
		}
		catch(NumberFormatException nex) {
			throw new BookLendException("Id must be numaric", nex);
		}
		}
		
		List<BookLendDetails> returnDetails = new ArrayList<BookLendDetails>();
		
		//returnuing book
		for(int ID : issued) {
			if(ID != 0) {
				BookLendDetails returnDetail = bookService.returnBook(ID);
			
				if(returnDetail  == null) {
					System.out.println("not returned");
					return new BookLendResponse("unable to return book",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);	
				}
		
				returnDetails.add(returnDetail);
		}
		}
		BookLendResponse response = new BookLendResponse("Book returned","200",HttpStatus.OK,returnDetails);
			
		return response;
			
		
	}
	
	@GetMapping(value= "/fetchAllReturnedBook")
	public BookLendResponse<List<BookLendDetails>> fetchAllReturnedBook(@RequestParam("ReturnDate") String ReturnDate) throws BookLendException{
		
		if(ReturnDate == null) {
			return new BookLendResponse(" return date is null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);	
		}
		
		Date date = null;
		try {
			date = DateUtility.formattedDate(ReturnDate, "MM/dd/yyyy");
		
		} catch (ParseException e) {
			System.out.println("Date is not valid");
			throw new BookLendException("Date is not valid",e);
							
		}
		
		List<BookLendDetails> bookdetails = bookService.listAllReturnedBookInGivenDate(date);
		
		if(bookdetails.size() == 0 || bookdetails == null)
			return new BookLendResponse("No book Returned","200",HttpStatus.OK,bookdetails);
		
		
		return new BookLendResponse("book Returned","200",HttpStatus.OK,bookdetails);
	}
	
	@GetMapping(value= "/fetchAllReturnedBookInGivenInterval")
	public BookLendResponse<List<BookLendDetails>> fetchAllReturnedBookInGivenInterva(
			@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate) throws BookLendException{
		
		if(startDate == null || endDate == null) {
			return new BookLendResponse(" date are null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);	
			
		}
		
		Date start = null;
		Date end = null;
		try {
			start = DateUtility.formattedDate(startDate, "MM/dd/yyyy");
			end = DateUtility.formattedDate(endDate, "MM/dd/yyyy");
			
		} catch (ParseException e) {
			System.out.println("Date is not valid");
			throw new BookLendException("Date is not valid",e);
		}
		
		List<BookLendDetails> bookdetails = bookService.findAllReturnedBooksInGivenTime(start, end);
		
		if(bookdetails.size() == 0 || bookdetails == null)
			return new BookLendResponse("No book Returned","200",HttpStatus.OK,bookdetails);
		
		return new BookLendResponse("book Returned","200",HttpStatus.OK,bookdetails);
	}
	
	@GetMapping(value= "/fetchAllIssuedBook")
	public BookLendResponse<List<BookLendDetails>> fetchAllIssuedBook(@RequestParam("issueDate") String issueDate) throws BookLendException{
		
		if(issueDate == null) {
			return new BookLendResponse(" date are null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);	
		}
		
		Date date = null;
		try {
			date = DateUtility.formattedDate(issueDate, "yyyy-MM-dd");
		
		} catch (ParseException e) {
			System.out.println("Date is not valid");
			throw new BookLendException("Date is not valid",e);
		}
		
		List<BookLendDetails> bookdetails = bookService.findAllIssuedBooksInGivenDate(date);
		
		if(bookdetails.size() == 0 || bookdetails == null)
			return new BookLendResponse("No book Returned","200",HttpStatus.OK,bookdetails);
		
		
		return new BookLendResponse("book Returned","200",HttpStatus.OK,bookdetails);
	}
	
	@GetMapping(value= "/fetchAllIssuedBookInGivenInterval")
	public BookLendResponse<List<BookLendDetails>> fetchAllIssuedBookInGivenInterva(
			@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate) throws BookLendException{
		
		if(startDate == null || endDate == null) {
			return new BookLendResponse(" date are null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		
		Date start = null;
		Date end = null;
		try {
			start = DateUtility.formattedDate(startDate, "MM/dd/yyyy");
			end = DateUtility.formattedDate(endDate, "MM/dd/yyyy");
			
		} catch (ParseException e) {
			System.out.println("Date is not valid");
			throw new BookLendException("Date is not valid",e);
		}
		
		List<BookLendDetails> bookdetails = bookService.findAllIssuedBooksInGivenTime(start, end);
		
		if(bookdetails.size() == 0 || bookdetails == null)
			return new BookLendResponse("No book Returned","200",HttpStatus.OK,bookdetails);
		
		return new BookLendResponse("book Returned","200",HttpStatus.OK,bookdetails);
	}
	
	
}
