package com.example.demo.config;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class CustomResponseEntityErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex,
		HttpHeaders headers,
		HttpStatus status,
		WebRequest request
    ){
		Map<String, List<FieldError>> result = new HashMap<String, List<FieldError>>();
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		for (FieldError error : errors) {
			result.put(error.getCode(), errors);
			//error.getField();
			//error.getDefaultMessage();
		}
        return ResponseEntity.status(status).headers(headers).body(result);
    }

    @ExceptionHandler({DuplicateKeyException.class, EntityNotFoundException.class})
    public ResponseEntity<ApiResponse> handleJpa(Exception ex) {
    	return ResponseEntity.status(HttpStatus.CONFLICT).body(
    			new ApiResponse(ex.getClass().getSimpleName().toString(),ex.getLocalizedMessage()));
    }
}
