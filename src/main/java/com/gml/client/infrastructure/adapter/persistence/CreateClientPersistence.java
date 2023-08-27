package com.gml.client.infrastructure.adapter.persistence;

import org.springframework.stereotype.Repository;

import com.gml.client.domain.model.Client;
import com.gml.client.domain.port.CreateClientRepository;
import com.gml.client.infrastructure.adapter.persistence.entity.ClientEntity;
import com.gml.client.infrastructure.adapter.persistence.mapper.ClientEntityMapper;
import com.gml.client.infrastructure.adapter.persistence.repository.ClientRepository;

@Repository
public class CreateClientPersistence implements CreateClientRepository  {

	private final ClientRepository clientRepository;

	private final ClientEntityMapper clientEntityMapper;

	public CreateClientPersistence(ClientRepository clientRepository, ClientEntityMapper clientEntityMapper) {
		this.clientRepository = clientRepository;
		this.clientEntityMapper = clientEntityMapper;
	}

	@Override
	public Client execute(Client client) {
		ClientEntity clientEntity = clientEntityMapper.toEntity(client);
		return clientEntityMapper.toModel(clientRepository.save(clientEntity));
	}

}
