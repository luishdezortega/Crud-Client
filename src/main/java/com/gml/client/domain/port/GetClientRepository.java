package com.gml.client.domain.port;

import com.gml.client.domain.model.Client;

@FunctionalInterface
public interface GetClientRepository {
	Client execute(String sharedKey);
}
