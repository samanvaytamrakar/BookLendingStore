package com.bookLend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookLend.model.BookLendErrorResponse;
import com.bookLend.model.BookLendResponse;


@ControllerAdvice
public class BookLendExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ BookLendException.class})
	public ResponseEntity<BookLendResponse<BookLendErrorResponse>> exceHandle(BookLendException ex, WebRequest req){
		
		BookLendErrorResponse error = new BookLendErrorResponse(ex.getStatus().value(),ex.getMessage());
		error.setApiName(req.getDescription(false));
		error.setError(ex.getStatus().name());
		
		BookLendResponse<BookLendErrorResponse> serviceResp = new BookLendResponse<BookLendErrorResponse>("Exception occured",
				ex.getStatus().getReasonPhrase(),HttpStatus.EXPECTATION_FAILED, error);
		
		ResponseEntity<BookLendResponse<BookLendErrorResponse>> response = new ResponseEntity<BookLendResponse<BookLendErrorResponse>>(
				serviceResp,HttpStatus.EXPECTATION_FAILED);
		
		return response;
	}
	
}
