package com.bookLend.dao;

import java.util.List;

import com.bookLend.entity.EmployeeDetails;
import com.bookLend.entity.LoginDetails;

public interface EmployeeDao {

	public EmployeeDetails findEmployeeById(int id);
	
	public EmployeeDetails addEmployeeData(EmployeeDetails emp);

	public Boolean deleteEmployeeData(int id);

	public EmployeeDetails updateEmployee(EmployeeDetails emp);

	public List<EmployeeDetails> getAllEmployeeData();
	
	public List<EmployeeDetails> findEmployeeByRole(String role);
	
	public LoginDetails addEmpInLoginTable(LoginDetails login);
	
	public LoginDetails searchEmpInLoginTable( int id);
	
	public String deleteEmpFromLoginTable(LoginDetails details);
}
