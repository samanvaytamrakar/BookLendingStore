package com.bookLend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookLend.Service.Impl.AddDataFromCsvService;
import com.bookLend.entity.BookDetails;
import com.bookLend.entity.CustomerDetails;
import com.bookLend.entity.EmployeeDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.BookLendResponse;

@RestController
@RequestMapping("/readCsv")
public class ReadDataFromfileController {

	@Autowired
	AddDataFromCsvService addData;
	
	@GetMapping(value= "/loadData")
	public BookLendResponse<List<Object>> loadData(
			@RequestParam(value= "fileName", required = true) String fileName) throws BookLendException{
		
		
		BookLendResponse<List<Object>> response = null;
		List<Object> list = new ArrayList<>();
		
		if(fileName.trim().equalsIgnoreCase("BookDetails.csv")) {
			List<BookDetails> data = addData.addBookfromCsv( fileName);
			list.addAll(data);
			return new BookLendResponse<List<Object>>("Books added sucessfully","200",HttpStatus.ACCEPTED,list);
		}
		
		if(fileName.trim().equalsIgnoreCase("EmployeeDetails.csv")) {
			List<EmployeeDetails> data = addData.addEmployeefromCsv(fileName);
			list.addAll(data);
			return new BookLendResponse<List<Object>>("Employees are  added sucessfully","200",HttpStatus.ACCEPTED,list);
		
		}
		
		if(fileName.trim().equalsIgnoreCase("CustomerDetails.csv")) {
			List<CustomerDetails> data = addData.addCustomerfromCsv( fileName);
			list.addAll(data);
			return new BookLendResponse<List<Object>>("Books added sucessfully","200",HttpStatus.ACCEPTED,list);
		
		}
		
		else
			throw new BookLendException("please enter a valid File name ");
		
		
	}
		
}
