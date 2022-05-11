package com.bookLend.model;

public class BookLendErrorResponse {

	private int status;
	private String error;
	private String apiName;
	private String msg;
	
	public BookLendErrorResponse() {
		
	}
	
	
	public BookLendErrorResponse(int status, String error) {
		super();
		this.status = status;
		this.error = error;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the apiName
	 */
	public String getApiName() {
		return apiName;
	}
	/**
	 * @param apiName the apiName to set
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
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
	
	
}
