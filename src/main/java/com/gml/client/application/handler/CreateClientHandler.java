package com.gml.client.application.handler;

import org.springframework.stereotype.Component;

import com.gml.client.application.dto.ClientRequestDto;
import com.gml.client.application.dto.ClientResponseDto;
import com.gml.client.application.factory.ClientFactory;
import com.gml.client.application.mapper.ClientMapper;
import com.gml.client.domain.service.CreateClientService;

@Component
public class CreateClientHandler {

	private final CreateClientService createClientService;
	private final ClientFactory clientFactory;
	private final ClientMapper clientMapper;

	public CreateClientHandler(CreateClientService createClientService, ClientFactory clientFactory,
			ClientMapper clientMapper) {
		this.createClientService = createClientService;
		this.clientFactory = clientFactory;
		this.clientMapper = clientMapper;
	}

	public ClientResponseDto execute(ClientRequestDto clientRequestDto) {
		return clientMapper.toDto(createClientService.execute(clientFactory.buildClient(clientRequestDto)));
	}

}
