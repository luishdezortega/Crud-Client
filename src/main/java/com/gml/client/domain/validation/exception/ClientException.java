package com.gml.client.domain.validation.exception;

public class ClientException extends RuntimeException {

	private static final long serialVersionUID = 8918303097908711059L;

	public ClientException(String message) {
		super(message);
	}
}