package com.bookLend.controller;

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
import com.bookLend.entity.BookDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.BookLendResponse;
import com.bookLend.utility.constants.bookStoreConstants;

@RestController
@RequestMapping("/User/Book")
//@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping(value= "/saveBookDetails" )
	public BookLendResponse<BookDetails> saveBook(@RequestBody BookDetails book){
		
		System.out.println("inside controller");
		if(book == null) {
			System.out.println("detail not found");
			return new BookLendResponse("Book Id is Null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		
		}
		BookDetails bookDetail = bookService.saveBook(book);
		
		if(bookDetail  == null) {
			System.out.println("detail not added");
			return new BookLendResponse(bookStoreConstants.PROCESSFAILD,bookStoreConstants.badRequest,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		BookLendResponse response = new BookLendResponse(bookStoreConstants.successMsg,"200",HttpStatus.OK,bookDetail);
		
		return response;
	}
	
	@GetMapping(value= "/removeBook")
	public BookLendResponse<String> removeBook(
			@RequestParam(value= "bookId", required = true) String bookId) throws BookLendException{
		
		if(bookId == null) {
			System.out.println("Id is null");
			return new BookLendResponse("Book Id is Null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		try {
			int Id = Integer.parseInt(bookId.trim());
			
			String result = bookService.deleteBookById(Id);
			
			if(result != null && result != "") {
				return new BookLendResponse("Book deleted","200",HttpStatus.OK,result);
			}
			return new BookLendResponse("Book not deleted","200",HttpStatus.OK,result);
		}
		catch(NumberFormatException nex) {
			throw new BookLendException("bOOK Id is not valid",nex);
		}
	}
	
	@GetMapping(value= "/fetchAllBooks")
	public BookLendResponse<List<BookDetails>> fetchAllBooks(){
		
		List<BookDetails> bookdetails = bookService.fetchAllBooks();
		
		if(bookdetails.size() > 0 )
			return new BookLendResponse("Success","200",HttpStatus.OK,bookdetails);
		
		return new BookLendResponse("Bookdetails are not Available","200",HttpStatus.OK);
	}
	
	@GetMapping(value= "/searchBookByAuthor")
	public BookLendResponse<List<BookDetails>> searchBookByAuthor(
			@RequestParam(value= "author", required = true) String author){
	
		if(author == null || author == "") {
			return new BookLendResponse("please enter author name",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST,null);
		}
		
		List<BookDetails> bookdetails = bookService.findBookByAuthor(author);
		System.out.println(bookdetails);
		if(bookdetails.size()>0)
		return new BookLendResponse("Success","200",HttpStatus.OK,bookdetails);
		
		else
		return new BookLendResponse("This author does not have any books","200",HttpStatus.OK,bookdetails);
		
	}
	
	
	@GetMapping(value= "/searchBookByPublisher")
	public BookLendResponse<List<BookDetails>> searchBookByPublisher(
			@RequestParam(value= "Publisher", required = true) String Publisher){
	
		if(Publisher == null || Publisher == "") {
			return new BookLendResponse("please enter Publisher name",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST,null);
		}
		
		List<BookDetails> bookdetails = bookService.findBookByPublisher(Publisher);
		
		if(bookdetails.size()>0)
			return new BookLendResponse("Success","200",HttpStatus.OK,bookdetails);
		
		return new BookLendResponse("This publisher does not have any books","200",HttpStatus.OK,bookdetails);
		
	}
	
	@GetMapping(value= "/removeBookByAuthor")
	public BookLendResponse<String> removeBookByAuthor(
			@RequestParam(value= "author", required = true) String author){
	
		if(author == null || author == "") {
			return new BookLendResponse("please enter author name",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST,null);
		}
		
		String book = bookService.deleteBooksofAuther(author);
		
		if(book == null || book == " ") {
			return new BookLendResponse("Books are not deleted","200",HttpStatus.OK,book);
		}
		
		return new BookLendResponse("Success","200",HttpStatus.OK,book);
	}
	
	@GetMapping(value= "/removeBookByPublisher")
	public BookLendResponse<String> removeBookByPublisher(
			@RequestParam(value= "Publisher", required = true) String Publisher){
	
		if(Publisher == null || Publisher == "") {
			return new BookLendResponse("please enter Publisher name",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST,null);
		}
		
		
		String book = bookService.deleteBooksOfPublisher(Publisher);
		
		if(book == null || book == " ") {
			return new BookLendResponse("Books are not deleted","200",HttpStatus.OK,book);
		}
		
		
		return new BookLendResponse("Success","200",HttpStatus.OK,book);
	}
	
	
	
	

	
}
