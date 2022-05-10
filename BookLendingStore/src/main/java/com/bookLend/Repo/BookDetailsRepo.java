package com.bookLend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookLend.entity.BookDetails;

@Repository
public interface BookDetailsRepo extends CrudRepository<BookDetails,Integer> {

	@Query(value = "select * from BOOKDETAILS where Auther = :Author", nativeQuery = true)
	public List<BookDetails> getBookByAuthor(@Param("Author")String Author);
	
	@Query(value = "select * from BOOKDETAILS where publisher = :publisher", nativeQuery = true)
	public List<BookDetails> getBookByPublisher(@Param("publisher")String publisher);
	
}
