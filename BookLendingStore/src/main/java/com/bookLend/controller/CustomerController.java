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

import com.bookLend.Service.CustomerService;
import com.bookLend.entity.CustomerDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.BookLendResponse;
import com.bookLend.utility.constants.bookStoreConstants;

@RestController
@RequestMapping("/User/CustomerManagement")
//@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@PostMapping(value= "/saveCustomerDetails" )
	public BookLendResponse<CustomerDetails> saveCustomer(@RequestBody CustomerDetails customer) throws BookLendException{
		
		if(customer == null) {
			System.out.println("detail not found");
			return new BookLendResponse("Details are Null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		
		CustomerDetails cust = custService.addCustomer(customer);
		
		if(cust == null) {
			System.out.println("detail not added");
			throw new BookLendException("detail not added");
		}
		
		BookLendResponse response = new BookLendResponse("Customer saved","200",HttpStatus.OK,cust);
		
		return response;
	}
	
	@GetMapping(value= "/removeCustomerDetail")
	public BookLendResponse<String> removeCustomer(
			@RequestParam(value= "CustomerId", required = true) String CustomerId){
		
		if(CustomerId == null) {
			System.out.println("Id is null");
			return new BookLendResponse("Id is null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		
		try {
			int custId = Integer.parseInt(CustomerId.trim());
			
			String result = custService.deleteCustomer(custId);
			
			if(result != null && result != "") {
				return new BookLendResponse("Customer deleted","200",HttpStatus.OK,result);
			}
			return new BookLendResponse("Customer not deleted","200",HttpStatus.OK,result);
		}
		catch(NumberFormatException nex) {
			return new BookLendResponse("Customer Id is not valid","400",HttpStatus.BAD_REQUEST,"Id must be numaric");
		}
	}
	
	@GetMapping(value= "/fetchAllCustomerDetail")
	public BookLendResponse<List<CustomerDetails>> fetchAllCustomers(){
		
		List<CustomerDetails> custdetails = custService.getAllCustomer();
		
		if(custdetails.size() > 0 )
			return new BookLendResponse("Success","200",HttpStatus.OK,custdetails);
		
		return new BookLendResponse("No records","200",HttpStatus.OK,custdetails);
		 
	}
	
	@GetMapping(value= "/searchCustomer")
	public BookLendResponse<CustomerDetails> searchCustomer(
			@RequestParam(value= "customerId", required = true) String customerId){
	
		if(customerId == null) {
			System.out.println("Id is null");
			return new BookLendResponse("Id is null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		try {
			
			int custId = Integer.parseInt(customerId.trim());
			
			CustomerDetails custdetails = custService.searchCustomer(custId);
		
			if(custdetails == null)
				return new BookLendResponse("Customer not found","200",HttpStatus.OK,null);
			
			return new BookLendResponse("Success","200",HttpStatus.OK,custdetails);
		}
		catch(NumberFormatException nex) {
			return new BookLendResponse("Customer Id is not valid","400",HttpStatus.BAD_REQUEST,"Id must be numaric");
		}
	}

	
}
