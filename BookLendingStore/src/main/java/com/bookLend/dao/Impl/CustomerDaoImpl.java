package com.bookLend.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookLend.Repo.CustomerDetailsRepo;
import com.bookLend.dao.CustomerDao;
import com.bookLend.entity.CustomerDetails;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	CustomerDetailsRepo custRepo;
	
	@Override
	public CustomerDetails addCustomer(CustomerDetails userdetail) {
		return custRepo.save(userdetail);
		
	}

	@Override
	public String deleteCustomer(int id) {
		custRepo.deleteById(id);
		return "Customer Deleted";
	}

	@Override
	public CustomerDetails updateAddress(int custId,String address1, String address2, String address3, String city,
			String pincode) {
		CustomerDetails customer = custRepo.findById(custId).get(); 
		customer.setAddress1(address1);
		customer.setAddress2(address2);
		customer.setAddress3(address3);
		customer.setCity(city);
		customer.setPincode(pincode);

		return custRepo.save(customer);
	}

	

	@Override
	public CustomerDetails searchCustomer(int userId) {
		return custRepo.findById(userId).get();
	}

	@Override
	public List<CustomerDetails> getAllCustomer() {
		
		return (List<CustomerDetails>) custRepo.findAll();
	}

}
