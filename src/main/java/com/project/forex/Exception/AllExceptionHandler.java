package com.project.forex.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {

	
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}	
	
	@ExceptionHandler({
		UserNotFoundException.class,
		UserAlreadyExistsException.class,
		Exception.class
		})
	public Map<String, String> handleAddressNotFoundException(Exception ex) {
	    Map<String, String> errors = new HashMap<>();
	    errors.put("Error", ex.toString());
	    errors.put("Message", ex.getMessage());
	    return errors;
	}

}
