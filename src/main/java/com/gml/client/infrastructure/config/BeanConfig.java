package com.gml.client.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gml.client.domain.port.CreateClientRepository;
import com.gml.client.domain.port.GetClientRepository;
import com.gml.client.domain.port.ListClientsRepository;
import com.gml.client.domain.service.CreateClientService;
import com.gml.client.domain.service.SearchClientService;

@Configuration
public class BeanConfig {

	@Bean
	CreateClientService createClientService(CreateClientRepository createClientRepository,
			GetClientRepository getClientRepository) {
		return new CreateClientService(createClientRepository, getClientRepository);
	}

	@Bean
	SearchClientService searchClientService(ListClientsRepository listClientsRepository,
			GetClientRepository getClientRepository) {
		return new SearchClientService(listClientsRepository, getClientRepository);
	}
}
