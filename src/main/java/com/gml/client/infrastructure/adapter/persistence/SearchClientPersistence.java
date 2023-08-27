package com.gml.client.infrastructure.adapter.persistence;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.gml.client.domain.model.Client;
import com.gml.client.domain.port.GetClientRepository;
import com.gml.client.domain.port.ListClientsRepository;
import com.gml.client.domain.validation.exception.ClientException;
import com.gml.client.infrastructure.adapter.persistence.entity.ClientEntity;
import com.gml.client.infrastructure.adapter.persistence.mapper.ClientEntityMapper;
import com.gml.client.infrastructure.adapter.persistence.mapper.PageableEntity;
import com.gml.client.infrastructure.adapter.persistence.repository.ClientRepository;

@Repository
public class SearchClientPersistence implements ListClientsRepository, GetClientRepository {

	private static final String NO_FOUND = "No results found";

	private final ClientRepository clientRepository;

	private final ClientEntityMapper clientEntityMapper;

	public SearchClientPersistence(ClientRepository clientRepository, ClientEntityMapper clientEntityMapper) {
		this.clientRepository = clientRepository;
		this.clientEntityMapper = clientEntityMapper;
	}

	@Override
	public PageableEntity<Client> execute(Pageable pageable) {

		Page<ClientEntity> resultSet = clientRepository.findAll(pageable);
		return new PageableEntity<>(resultSet.getTotalElements(), resultSet.getTotalPages(),
				resultSet.getContent().stream().map(clientEntityMapper::toModel).toList());

	}

	@Override
	public Client execute(String sharedKey) {

		Optional<ClientEntity> result = clientRepository.findBySharedKeyIs(sharedKey);
		if (result.isPresent()) {
			return clientEntityMapper.toModel(result.get());
		}
		throw new ClientException(NO_FOUND);
	}
}
