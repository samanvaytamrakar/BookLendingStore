package com.bookLend.exception;

import org.springframework.http.HttpStatus;

public class BookLendException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status ;
	
	public BookLendException(String msg) {
		super(msg);
		this.status = HttpStatus.BAD_REQUEST;
		
	}
	
	public BookLendException(String msg, Throwable cause) {
		super(msg, cause);
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
		
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
