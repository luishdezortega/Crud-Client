package com.gml.client.domain.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.gml.client.domain.model.Client;
import com.gml.client.domain.port.GetClientRepository;
import com.gml.client.domain.port.ListClientsRepository;
import com.gml.client.infrastructure.adapter.persistence.mapper.PageableEntity;

public class SearchClientService {

	private final ListClientsRepository listClientsRepository;

	private final GetClientRepository getClientRepository;

	public SearchClientService(ListClientsRepository listClientsRepository, GetClientRepository getClientRepository) {
		this.listClientsRepository = listClientsRepository;
		this.getClientRepository = getClientRepository;
	}

	public Client execute(String sharedKey) {
		return getClientRepository.execute(sharedKey);
	}

	public PageableEntity<Client> execute(Integer pageSize, Integer page) {
		Pageable paging = PageRequest.of(page, pageSize);
		return listClientsRepository.execute(paging);
	}

}
