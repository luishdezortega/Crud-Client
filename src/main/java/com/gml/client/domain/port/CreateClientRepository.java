package com.gml.client.domain.port;

import com.gml.client.domain.model.Client;

@FunctionalInterface
public interface CreateClientRepository {
	Client execute(Client client);
}
