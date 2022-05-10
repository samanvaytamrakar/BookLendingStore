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

import com.bookLend.Service.EmployeeService;
import com.bookLend.entity.EmployeeDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.BookLendResponse;
import com.bookLend.model.EmployeeModel;
import com.bookLend.utility.constants.bookStoreConstants;

@RestController
@RequestMapping("/Admin/EmployeeManagement")
//@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	
	
	@PostMapping(value= "/saveEmployeeDetails" )
	public BookLendResponse<EmployeeDetails> saveEmployee(@RequestBody EmployeeModel employee) throws BookLendException{
		
		if(employee == null) {
			System.out.println("detail not found");
			return new BookLendResponse("Details are Null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		
		EmployeeDetails emp = empService.addEmployee(employee);
		
		if(emp == null) {
			System.out.println("detail not added");
			throw new BookLendException("detail not added");
		}
		
		BookLendResponse response = new BookLendResponse("Employee saved","200",HttpStatus.OK,emp);
		
		return response;
	}
	
	@GetMapping(value= "/removeEmployeeDetail")
	public BookLendResponse<String> removeEmployee(
			@RequestParam(value= "employeeId", required = true) String employeeId) throws BookLendException{
		
		if(employeeId == null) {
			System.out.println("Id is null");
			return new BookLendResponse("Details are Null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		try {
			int empId = Integer.parseInt(employeeId.trim());
			
			String result = empService.deleteEmployee(empId);
			
			if(result != null && result != "") {
				return new BookLendResponse("Employee deleted","200",HttpStatus.OK,result);
			}
			return new BookLendResponse("Employee not deleted","200",HttpStatus.OK,result);
		}
		catch(NumberFormatException nex) {
			throw new BookLendException("please enter numeric id",nex);
		}
	}
	
	@GetMapping(value= "/fetchAllEmployeeDetail")
	public BookLendResponse<List<EmployeeDetails>> fetchAllEmployee(){
		
		List<EmployeeDetails> empdetails = empService.getAllEmployeeDetails();
		
		if (empdetails.size() >0)
			return new BookLendResponse("Success","200",HttpStatus.OK,empdetails);
		
		return new BookLendResponse("No Record Found","200",HttpStatus.OK,null);
		
	}
	
	@GetMapping(value= "/searchEmployeeByRole")
	public BookLendResponse<List<EmployeeDetails>> searchEmployeeByRole(
			@RequestParam(value= "role", required = true) String role){
	
		if(role == null || role == " ") {
			System.out.println("Id is null");
			return new BookLendResponse("Details are Null",bookStoreConstants.badRequest,HttpStatus.BAD_REQUEST);
		}
		
		List<EmployeeDetails> empdetails = empService.searchEmployeeByRole(role);
		
		if (empdetails.size() >0)
			return new BookLendResponse("Success","200",HttpStatus.OK,empdetails);
		
		return new BookLendResponse("No Record Found","200",HttpStatus.OK,null);
	}
	
}
