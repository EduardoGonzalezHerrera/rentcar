package lk.codelabs.rentcloud.customerservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lk.codelabs.rentcloud.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler( value= {Exception.class}) 
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request){
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription == null ) errorMessageDescription=ex.toString();
		
		ErrorMessage errorMessage=new ErrorMessage(new Date(),errorMessageDescription);
				
		//return new ResponseEntity<Object>(ex,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR );
		return new ResponseEntity<Object>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR );
	}

	
	@ExceptionHandler( value= {NullPointerException.class}) 
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex,WebRequest request){
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription == null ) errorMessageDescription=ex.toString();
		
		ErrorMessage errorMessage=new ErrorMessage(new Date(),"Error type: "+errorMessageDescription);
				
		//return new ResponseEntity<Object>(ex,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR );
		return new ResponseEntity<Object>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR );
	}
	
	@ExceptionHandler( value= {CustomerServiceException.class}) 
	public ResponseEntity<Object> customerServiceException(CustomerServiceException ex,WebRequest request){
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription == null ) errorMessageDescription=ex.toString();
		
		ErrorMessage errorMessage=new ErrorMessage(new Date(),"CustomerException: "+errorMessageDescription);
				
		//return new ResponseEntity<Object>(ex,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR );
		return new ResponseEntity<Object>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR );
	}
	
	
}
