package com.bookLend.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookLend.Repo.EmployeeDetailsRepo;
import com.bookLend.Repo.LoginDetailsRepo;
import com.bookLend.dao.EmployeeDao;
import com.bookLend.entity.EmployeeDetails;
import com.bookLend.entity.LoginDetails;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	public EmployeeDetailsRepo empRepo;
	
	@Autowired
	public LoginDetailsRepo loginRepo;
	
	/**
	 * Add the Employee data into database
	 */
	@Override
	public EmployeeDetails findEmployeeById(int id) {
		return empRepo.findById(id).get();
	}
	
	@Override
	public LoginDetails addEmpInLoginTable(LoginDetails login)
	{
		return loginRepo.save(login);
	}

	@Override
	public LoginDetails searchEmpInLoginTable( int id) {
		return loginRepo.searchUser(id);
	}
	

	public String deleteEmpFromLoginTable(LoginDetails details) {
		loginRepo.delete(details);
		return "data Deleted";
	}
	@Override
	public EmployeeDetails addEmployeeData(EmployeeDetails emp) {
		
		EmployeeDetails empDetails = empRepo.save(emp);
		return empDetails;
	}

	/**
	 * Delete employee by id
	 */
	@Override
	public Boolean deleteEmployeeData(int id) {
		empRepo.deleteById(id);
		return true;
	}

	@Override
	public EmployeeDetails updateEmployee( EmployeeDetails emp) {
		
		return empRepo.save(emp);
	
	}


	@Override
	public List<EmployeeDetails> getAllEmployeeData() {
		return (List<EmployeeDetails>) empRepo.findAll();
	}

	@Override
	public List<EmployeeDetails> findEmployeeByRole(String role) {
		List<EmployeeDetails> empData = empRepo.findByRole(role);
		return empData;
	}

}
