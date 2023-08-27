package com.gml.client.infrastructure.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gml.client.domain.validation.exception.ClientException;

@ControllerAdvice
public class ClientControllerHandler {

	@ExceptionHandler
	private ResponseEntity<String> sendResponse(Exception exception) {
		if (exception instanceof ClientException) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
