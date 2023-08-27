package com.gml.client.infrastructure.adapter.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gml.client.domain.model.Client;
import com.gml.client.infrastructure.adapter.persistence.entity.ClientEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientEntityMapper {

	ClientEntity toEntity(Client client);

	Client toModel(ClientEntity clientEntity);

}
