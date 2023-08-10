package com.jesusapmoro.jmsystem.services.exceptions;

//essa classe vai ser um subclasse do RuntimeExeptio do java, que é aquela exceção que o compilador não te obriga a tratar
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
