package com.bookLend.Service;

import com.bookLend.model.AunthenticationResponse;

public interface UserLoginService {

	public AunthenticationResponse aunthenticateUser(String userId,String password);
	
	
}
