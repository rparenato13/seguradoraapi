package com.renatoalmeida.seguradoraapi.services.exception;

public class InvalidArgumentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidArgumentException(String msg) {
		super(msg);
	}
}
