package com.bookLend.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookLend.entity.CustomerDetails;
@Repository
public interface CustomerDetailsRepo extends CrudRepository<CustomerDetails,Integer> {

}
