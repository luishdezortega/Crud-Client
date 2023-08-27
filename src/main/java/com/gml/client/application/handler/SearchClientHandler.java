package com.gml.client.application.handler;

import org.springframework.stereotype.Component;

import com.gml.client.application.dto.ClientResponseDto;
import com.gml.client.application.dto.PaginationResponseDto;
import com.gml.client.application.mapper.ClientMapper;
import com.gml.client.domain.model.Client;
import com.gml.client.domain.service.SearchClientService;
import com.gml.client.infrastructure.adapter.persistence.mapper.PageableEntity;

@Component
public class SearchClientHandler {

	private final SearchClientService searchClientService;
	private final ClientMapper clientMapper;

	public SearchClientHandler(SearchClientService searchClientService, ClientMapper clientMapper) {
		this.searchClientService = searchClientService;
		this.clientMapper = clientMapper;
	}

	public ClientResponseDto getClientBySharedKey(String sharedKey) {
		return clientMapper.toDto(searchClientService.execute(sharedKey));
	}

	public PaginationResponseDto<Client> getAllResults(Integer pageSize, Integer page) {

		PageableEntity<Client> resultSet = searchClientService.execute(pageSize, page);
		return clientMapper.toPageableDto(resultSet.getEntity(), resultSet.getTotalElements(), resultSet.getTotalPages());

	}

}
