package com.bookLend.Service;

import java.util.List;

import com.bookLend.entity.*;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.EmployeeModel;

/**
 * 
 * @author saman
 *
 */
public interface EmployeeService {

	//for adding employee
	public EmployeeDetails addEmployee(EmployeeModel emp);

	public String deleteEmployee(int id) throws BookLendException;

	public EmployeeDetails updateEmployeeRole(String role,int id) throws BookLendException;

	public EmployeeDetails updateEmployeeAddress(int id,String address1,String address2,String address3,String city,String pincode) throws BookLendException;
	
	public List<EmployeeDetails> getAllEmployeeDetails();
	
	public List<EmployeeDetails> searchEmployeeByRole(String role);
	
	
	
}
