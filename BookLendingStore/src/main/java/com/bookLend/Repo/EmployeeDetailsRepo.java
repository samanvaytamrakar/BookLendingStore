package com.bookLend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookLend.entity.EmployeeDetails;
@Repository
public interface EmployeeDetailsRepo extends CrudRepository<EmployeeDetails,Integer>{

	@Query(value="select * from Employee_Details where Role = :Role", nativeQuery=true)
	List<EmployeeDetails> findByRole(@Param("Role")String Role);

	
}
