package com.jesusapmoro.jmsystem.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jesusapmoro.jmsystem.services.exceptions.DatabaseException;
import com.jesusapmoro.jmsystem.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//@ControllerAdvice: interceptar as exceções que acontecerem para que esse objeto possa executar os tratamentos
@ControllerAdvice
public class ResourceExceptionHandler {

	//@ExceptionHandler : capaz de interceptar a requesição que deu exceção
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;//status 404
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
