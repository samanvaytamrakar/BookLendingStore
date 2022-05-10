package com.bookLend.model;

import org.springframework.http.HttpStatus;

public class BookLendResponse<T> {

	private String message;
	private String status;
	private HttpStatus code;
	private T payload;
	
	
	/**
	 * @param message
	 * @param status
	 * @param code
	 * @param payload
	 */
	public BookLendResponse() {
		
	}
	
	public BookLendResponse(String message,String status, HttpStatus code, T payload) {
		this.message = message;
		this.status = status;
		this.code = code;
		this.payload = payload;
	}

	/**
	 * @param message
	 * @param status
	 * @param code
	 */
	public BookLendResponse(String message,String status, HttpStatus code) {
		this.message = message;
		this.status = status;
		this.code = code;
	}
	
	
	
	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
	
	
	
	
}
