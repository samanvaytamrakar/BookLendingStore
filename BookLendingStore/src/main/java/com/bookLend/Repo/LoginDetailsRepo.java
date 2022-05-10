package com.bookLend.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookLend.entity.LoginDetails;

@Repository
public interface LoginDetailsRepo extends CrudRepository<LoginDetails,Integer>{

	@Query(value="select * from login_details where username = :username" , nativeQuery=true)
	Optional<LoginDetails> findByUserName(@Param("username") String username);
	
	
	@Query(value="select * from login_details where username = :username AND password = :password", nativeQuery=true)
	public String logInUser(@Param("username")String username,@Param("password")String Password);

	@Query(value="select * from login_details where Emp_id = :Emp_Id", nativeQuery=true)
	public LoginDetails searchUser(@Param("Emp_Id")int Emp_Id);
	
}
