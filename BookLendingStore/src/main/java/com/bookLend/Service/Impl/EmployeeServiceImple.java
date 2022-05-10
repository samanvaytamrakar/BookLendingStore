package com.bookLend.Service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookLend.Service.EmployeeService;
import com.bookLend.dao.EmployeeDao;
import com.bookLend.entity.EmployeeDetails;
import com.bookLend.entity.LoginDetails;
import com.bookLend.exception.BookLendException;
import com.bookLend.model.EmployeeModel;

@Service
@Transactional(rollbackFor = Exception.class)
//BookLendException.class)
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	public EmployeeDao empDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	/**
	 * for adding the employee details
	 */
	@Override
	public EmployeeDetails addEmployee(EmployeeModel emp) {
		EmployeeDetails details = empDao.addEmployeeData(emp.toEntity());
		LoginDetails login = new LoginDetails();
		if(details.getRole().equalsIgnoreCase("Admin")) {
			login.setUserName(emp.getUsername());
			login.setPassword(bcryptEncoder.encode(emp.getPassword()));
			login.setRole("Admin");
			login.setEmpid(details.getEmpId());
			login = empDao.addEmpInLoginTable(login);
		}else if(emp.getRole().equalsIgnoreCase("User")) {
			login.setUserName(emp.getUsername());
			login.setPassword(bcryptEncoder.encode(emp.getPassword()));
			login.setRole("User");
			login.setEmpid(details.getEmpId());
			login = empDao.addEmpInLoginTable(login);
		}
		return details;
	}

	/**
	 * for deleting the employee details
	 * @throws BookLendException 
	 */
	@Override
	public String deleteEmployee(int id) throws BookLendException {
		EmployeeDetails emp = empDao.findEmployeeById(id);
		
		if(emp == null)
			throw new BookLendException("Id is not present in database");
		
		String result = "";
		if(emp.getRole().equalsIgnoreCase("Admin") || emp.getRole().equalsIgnoreCase("User")) {
			LoginDetails login = empDao.searchEmpInLoginTable(emp.getEmpId());
			
			if(login == null)
				throw new BookLendException("Id is not present in Login database");
			
			empDao.deleteEmpFromLoginTable(login);
		}
		return (empDao.deleteEmployeeData(id) == true ?"Sucess":"Failed");
	}

	@Override
	public EmployeeDetails updateEmployeeRole(String role,int id) throws BookLendException {
		EmployeeDetails empdata = empDao.findEmployeeById(id);
		
		if(empdata == null)
			throw new BookLendException("Id is not present in database");
		
		
		empdata.setRole(role);
		return empDao.updateEmployee(empdata);
	}

	@Override
	public EmployeeDetails updateEmployeeAddress(int id,String address1, String address2, String address3, String city,
			String pincode) throws BookLendException {
		EmployeeDetails empdata = empDao.findEmployeeById(id);
		
		if(empdata == null)
			throw new BookLendException("Id is not present in database");
		
		empdata.setAddress1(address1);
		empdata.setAddress2(address2);
		empdata.setAddress3(address3);
		empdata.setCity(city);
		empdata.setPincode(pincode);
		return empDao.updateEmployee(empdata);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		
		return empDao.getAllEmployeeData();
	}

	@Override
	public List<EmployeeDetails> searchEmployeeByRole(String role) {
		return empDao.findEmployeeByRole(role);
	}

}
