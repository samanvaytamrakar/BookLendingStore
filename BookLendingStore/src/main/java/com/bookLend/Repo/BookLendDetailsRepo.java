package com.bookLend.Repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookLend.entity.BookLendDetails;

@Repository
public interface BookLendDetailsRepo extends CrudRepository<BookLendDetails, Integer> {

	
	@Query(value = "select * from Book_Lend_Details where Book_Id = :Book_Id", nativeQuery = true)
	public List<BookLendDetails> getIssuedBookByBookId(@Param("Book_Id")int Book_Id);
	
	@Query(value = "select * from Book_Lend_Details where Issue_Date = :Issue_Date", nativeQuery = true)
	public List<BookLendDetails> getIssuedBookByDate(@Param("Issue_Date")Date Issue_Date);
	
	@Query(value = "select * from Book_Lend_Details where Customer_Id = :Customer_Id", nativeQuery = true)
	public List<BookLendDetails> getIssuedBookByCustomeId(@Param("Customer_Id")int Customer_Id);
	
	@Query(value = "select * from Book_Lend_Details where Issue_Date = :startDate AND Issue_Date = :endDate", nativeQuery = true)
	public List<BookLendDetails> getIssuedBooksByDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
	
	@Query(value = "select * from Book_Lend_Details where Return_Date = :Return_Date", nativeQuery = true)
	public List<BookLendDetails> getReturnBookByDate(@Param("Return_Date")Date Return_Date);
	
	@Query(value = "select * from Book_Lend_Details where Return_Date = :startDate AND Return_Date = :endDate", nativeQuery = true)
	public List<BookLendDetails> getReturnBooksByDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
	
}
