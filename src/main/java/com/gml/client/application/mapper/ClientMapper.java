package com.gml.client.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gml.client.application.dto.ClientResponseDto;
import com.gml.client.application.dto.PaginationResponseDto;
import com.gml.client.domain.model.Client;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

	ClientResponseDto toDto(Client client);

	@Mapping(source = "numberOfElements", target = "numberOfElements")
	@Mapping(source = "numberOfPages", target = "numberOfPages")
	@Mapping(source = "responseDto", target = "responseDto")
	PaginationResponseDto<Client> toPageableDto(List<Client> responseDto, Long numberOfElements, Integer numberOfPages);
}
