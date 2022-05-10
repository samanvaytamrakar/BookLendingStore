package com.bookLend.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookLend.Service.CustomerService;
import com.bookLend.dao.CustomerDao;
import com.bookLend.entity.CustomerDetails;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao custDao;
	
	@Override
	public CustomerDetails addCustomer(CustomerDetails userdetail) {
		
		return custDao.addCustomer(userdetail);
		
	}

	@Override
	public String deleteCustomer(int id) {
		
		return null;
	}

	@Override
	public CustomerDetails updateCustomerAddress(int custId, String address1, String address2, String address3,
			String city, String pincode) {
		
		return custDao.updateAddress(custId, address1, address2, address3, city, pincode);
	}

	@Override
	public CustomerDetails searchCustomer(int userId) {
		return custDao.searchCustomer(userId);
	}

	@Override
	public List<CustomerDetails> getAllCustomer() {
		
		return custDao.getAllCustomer();
	}

}
