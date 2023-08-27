package com.gml.client.domain.service;

import java.time.LocalDate;

import com.gml.client.domain.model.Client;
import com.gml.client.domain.port.CreateClientRepository;
import com.gml.client.domain.port.GetClientRepository;
import com.gml.client.domain.validation.exception.ClientException;

public class CreateClientService {

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
				throw new ClientException(SHARED_KEY_EXITS);
			}
		} catch (ClientException e) {
			if (e.getMessage().equals(SHARED_KEY_EXITS)) {
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
