package com.gml.client.domain.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gml.client.domain.model.Client;
import com.gml.client.domain.port.CreateClientRepository;
import com.gml.client.domain.port.GetClientRepository;
import com.gml.client.domain.validation.exception.ClientException;

public class CreateClientService {

	Logger logger = LoggerFactory.getLogger(CreateClientService.class);

	private static final String SHARED_KEY_EXITS = "The generated shared key already exists in the system, contact support";

	private final CreateClientRepository createClientRepository;

	private final GetClientRepository getClientRepository;

	public CreateClientService(CreateClientRepository createClientRepository, GetClientRepository getClientRepository) {
		this.createClientRepository = createClientRepository;
		this.getClientRepository = getClientRepository;
	}

	public Client execute(Client client) {
		return createClientRepository.execute(buildSharedKeyAndBindingDate(client));
	}

	private void validateIfSharedKeyExits(String sharedKey) {

		try {
			if (getClientRepository.execute(sharedKey) != null) {
				logger.error("There is a client with the same name");
				throw new ClientException(SHARED_KEY_EXITS);
			}
			logger.info("No customer with the same name found");
		} catch (ClientException e) {
			if (e.getMessage().equals(SHARED_KEY_EXITS)) {
				logger.error("There is a client with the same name");
				throw new ClientException(SHARED_KEY_EXITS);
			}
		}
	}

	private Client buildSharedKeyAndBindingDate(Client cliente) {

		StringBuilder sharedKey = new StringBuilder();
		sharedKey.append(cliente.getName().charAt(0));
		sharedKey.append(cliente.getName().split(" ")[1]);

		String auxSharedKey = sharedKey.toString().toLowerCase();
		validateIfSharedKeyExits(auxSharedKey);

		cliente.setSharedKey(auxSharedKey);
		cliente.setBindingDate(LocalDate.now());

		return cliente;
	}

}
