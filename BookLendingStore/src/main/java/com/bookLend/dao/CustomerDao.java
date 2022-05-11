package com.bookLend.dao;

import java.util.List;

import com.bookLend.entity.CustomerDetails;

public interface CustomerDao {

	public CustomerDetails addCustomer(CustomerDetails userdetail);
	
	public String deleteCustomer(int id);
	
	public CustomerDetails updateAddress(int custId,String address1,String address2,String address3,String city,String pincode);
	
	public CustomerDetails searchCustomer(int userId);
	
	public List<CustomerDetails> getAllCustomer();

	List<CustomerDetails> addListOfCustomer(List<CustomerDetails> userdetail);

}
