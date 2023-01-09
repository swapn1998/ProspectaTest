package com.prospecta.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


public class GolbalException {

	
	
	@ExceptionHandler(entryException.class)
	public ResponseEntity<myErrorDetails> entryExceptionHandler(entryException er,WebRequest req){
		
		myErrorDetails errorDetails=new myErrorDetails();
		
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(er.getMessage());
        errorDetails.setDescription(req.getDescription(false));
        
        return new ResponseEntity<myErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
        
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<myErrorDetails> notFoundExceptionHandler(NoHandlerFoundException nfe, WebRequest req ){
		
		myErrorDetails err = new myErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<myErrorDetails> ExceptionHandler(Exception er,WebRequest req){
		
		myErrorDetails errorDetails=new myErrorDetails();
		
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(er.getMessage());
        errorDetails.setDescription(req.getDescription(false));
        
        return new ResponseEntity<myErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
        
	}
	
	
}
