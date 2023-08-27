package com.gml.client.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gml.client.application.dto.ClientRequestDto;
import com.gml.client.application.dto.ClientResponseDto;
import com.gml.client.application.dto.PaginationResponseDto;
import com.gml.client.application.handler.CreateClientHandler;
import com.gml.client.application.handler.SearchClientHandler;
import com.gml.client.domain.model.Client;

import io.swagger.annotations.Api;

@Api("Api Rest para consultar información del empleado")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClientController {

	private final CreateClientHandler createClientHandler;

	private final SearchClientHandler searchClientHandler;

	public ClientController(CreateClientHandler createClientHandler, SearchClientHandler searchClientHandler) {
		this.createClientHandler = createClientHandler;
		this.searchClientHandler = searchClientHandler;
	}

	@GetMapping("/client/{sharedKey}")
	public ResponseEntity<ClientResponseDto> getClienBySharedKey(@PathVariable String sharedKey) {
		return ResponseEntity.ok(searchClientHandler.getClientBySharedKey(sharedKey));
	}

	@GetMapping("/clients")
	public ResponseEntity<PaginationResponseDto<Client>> getAllClients(
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "0", required = false) Integer page) {
		return ResponseEntity.ok(searchClientHandler.getAllResults(pageSize, page));
	}

	@PostMapping("/client")
	public ResponseEntity<ClientResponseDto> createClient(@RequestBody ClientRequestDto clientRequestDto) {
		return ResponseEntity.ok(createClientHandler.execute(clientRequestDto));
	}

}
