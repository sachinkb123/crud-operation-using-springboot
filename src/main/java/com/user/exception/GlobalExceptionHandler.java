package com.user.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleUserNotFoundExcpetion(UserNotFoundException ex, WebRequest request){
		 Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", HttpStatus.NOT_FOUND.value());
	        body.put("error", "User Not Found");
	        body.put("message", ex.getMessage());
	        body.put("path", request.getDescription(false).substring(4));

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	}
