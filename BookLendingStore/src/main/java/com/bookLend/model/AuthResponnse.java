package com.bookLend.model;

public class AuthResponnse {

	private String jwt;

	private String username;
	
	private String role;
	
	private String msg;
	
	
	
	/**
	 * @param jwt
	 * @param username
	 * @param role
	 * @param msg
	 */
	public AuthResponnse(String jwt, String username, String msg) {
		super();
		this.jwt = jwt;
		this.username = username;
		//this.role = role;
		this.msg = msg;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param jwt
	 */
	public AuthResponnse(String username,String jwt) {
		this.username = username;
		this.jwt = jwt;
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
