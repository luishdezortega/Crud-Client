package com.gml.client.domain.port;

import org.springframework.data.domain.Pageable;

import com.gml.client.domain.model.Client;
import com.gml.client.infrastructure.adapter.persistence.mapper.PageableEntity;

@FunctionalInterface
public interface ListClientsRepository {
	PageableEntity<Client> execute(Pageable pageable);
}
