package com.gml.client.application.factory;

import org.springframework.stereotype.Component;

import com.gml.client.application.dto.ClientRequestDto;
import com.gml.client.application.validation.ArgumentValidation;
import com.gml.client.domain.model.Client;

@Component
public class ClientFactory {

	private void validateInput(ClientRequestDto clientRequestDto) {
		ArgumentValidation.validateFullName(clientRequestDto.getName());
		ArgumentValidation.validateMail(clientRequestDto.getMail());
		ArgumentValidation.validatePhoneNumber(clientRequestDto.getPhone());
	}

	public Client buildClient(ClientRequestDto clientRequestDto) {
		validateInput(clientRequestDto);
		return Client.builder().name(clientRequestDto.getName()).mail(clientRequestDto.getMail())
				.phone(clientRequestDto.getPhone()).startDate(clientRequestDto.getStartDate())
				.endDate(clientRequestDto.getEndDate()).build();
	}
}