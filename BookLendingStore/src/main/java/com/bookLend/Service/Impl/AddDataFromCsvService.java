package com.bookLend.Service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookLend.Service.EmployeeService;
import com.bookLend.dao.BookDao;
import com.bookLend.dao.CustomerDao;
import com.bookLend.entity.BookDetails;
import com.bookLend.entity.CustomerDetails;
import com.bookLend.entity.EmployeeDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.EmployeeModel;
import com.bookLend.utility.CSVOperations;

@Service
public class AddDataFromCsvService {

	@Autowired
	BookDao bookDao;
	
	@Autowired
	EmployeeService empDao;
	
	@Autowired
	CustomerDao custDao;
	
	public List<BookDetails> addBookfromCsv(String fileName) throws BookLendException{
		
		try {
		List<String> allLines = CSVOperations.readCsvFile(fileName);
		
		System.out.println("2 file read done"+ allLines.size());
		
		if(allLines == null || allLines.size() == 0)
			throw new BookLendException("file is empty");
		
		List<BookDetails> details = new ArrayList<BookDetails>();
		
		for(int i = 0; i < allLines.size(); i++) {
			
			if(i==0)
				continue;
			
			List<String> line = CSVOperations.readFileLine(allLines.get(i));
			System.out.println("3 file read done"+ line.size());
			BookDetails book = new BookDetails();
			book.setBookName(line.get(0));
			book.setYearOfPublish(line.get(1));
			book.setPublisher(line.get(2));
			book.setAuther(line.get(3));
			book.setBookCount(Integer.parseInt( line.get(4).trim()));
			book.setCost(Double.parseDouble(line.get(5).trim()));
			book.setLendingCost(Double.parseDouble(line.get(6).trim()));
			
			details.add(book);
		}
		
		System.out.println(details.size()+"  value:  "+ details.toString());
		return bookDao.addListOfBook(details);
		
		}
		catch(IOException io) {
			io.printStackTrace();
			throw new BookLendException("Exception occured while reading the file", io);
		}
		catch(NumberFormatException ipex) {
			throw new BookLendException("Exception occured while converting the cost ");
		}
	}
	
	
	public List<EmployeeDetails> addEmployeefromCsv(String fileName) throws BookLendException{
		
		try {
		List<String> allLines = CSVOperations.readCsvFile(fileName);
		
		if(allLines == null || allLines.size() == 0)
			throw new BookLendException("file is empty");
		
		List<EmployeeDetails> details = new ArrayList<EmployeeDetails>();
		
		for(int i = 1; i < allLines.size(); i++) {
			
			List<String> line = CSVOperations.readFileLine(allLines.get(i));
			
			EmployeeModel emp = new EmployeeModel();
			emp.setName(line.get(0));
			emp.setRole(line.get(1));
			emp.setMail(line.get(2));
			emp.setAddress1(line.get(3));
			emp.setAddress2(line.get(4));
			emp.setAddress3(line.get(5));
			emp.setCity(line.get(6));
			emp.setPincode(line.get(7));
			emp.setUsername(line.get(8));
			emp.setPassword(line.get(9));
			
			details.add(empDao.addEmployee(emp));
		}
		
		return details;
		
		}
		catch(IOException io) {
			throw new BookLendException("Exception occured while reading the file");
		}
		catch(NumberFormatException ipex) {
			throw new BookLendException("Exception occured while converting the cost ");
		}
	}
	
	public List<CustomerDetails> addCustomerfromCsv(String fileName) throws BookLendException{
		
		try {
		List<String> allLines = CSVOperations.readCsvFile(fileName);
		
		if(allLines == null || allLines.size() == 0)
			throw new BookLendException("file is empty");
		
		List<CustomerDetails> details = new ArrayList<CustomerDetails>();
		
		for(int i = 1; i < allLines.size(); i++) {
			
			List<String> line = CSVOperations.readFileLine(allLines.get(i));
			
			CustomerDetails customer = new CustomerDetails();
			customer.setName(line.get(0));
			customer.setContactNumber(line.get(1));
			customer.setMail(line.get(2));
			customer.setAddress1(line.get(3));
			customer.setAddress2(line.get(4));
			customer.setAddress3(line.get(5));
			customer.setCity(line.get(6));
			customer.setPincode(line.get(7));
			
			details.add(customer);
		}
		
		return custDao.addListOfCustomer(details);
		
		}
		catch(IOException io) {
			throw new BookLendException("Exception occured while reading the file");
		}
		catch(NumberFormatException ipex) {
			throw new BookLendException("Exception occured while converting the cost ");
		}
	}
}
