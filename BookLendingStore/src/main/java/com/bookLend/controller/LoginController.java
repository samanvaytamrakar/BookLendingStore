package com.bookLend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookLend.config.MyUserDetailsService;
import com.bookLend.jwt.util.JwtUtil;
import com.bookLend.model.AuthRequest;
import com.bookLend.model.AuthResponnse;


@RestController
//@RequestMapping("")
public class LoginController {


	@Autowired
	private AuthenticationManager authManager;


	@Autowired
	private MyUserDetailsService myService;
	
	@Autowired
	private JwtUtil jutil;
	
	
	
	@PostMapping("/validate")
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest aReq) throws Exception{

		System.out.println("inside controller");
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(aReq.getUsername(), aReq.getPassword())
			);
			
			System.out.println("validation done");
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = myService
				.loadUserByUsername(aReq.getUsername());

		final String jwt = jutil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponnse(jwt,userDetails.getUsername(),"User Varified"));
	}
}
