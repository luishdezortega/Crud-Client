package com.gml.client.builder;

import java.time.LocalDate;

import com.gml.client.application.dto.ClientRequestDto;
import com.gml.client.domain.model.Client;

public class ClientBuilder {

	public ClientRequestDto builderRequestClientDto() {
		return ClientRequestDto.builder().name("Luis Hernandez").mail("luis@gmail.com").phone("3046825465")
				.startDate(LocalDate.now()).endDate(LocalDate.now()).build();
	}

	public Client builderClient() {
		return Client.builder().name("Luis Hernandez").mail("luis@gmail.com").phone("3046825465")
				.sharedKey("lhernandez").bindingDate(LocalDate.now()).startDate(LocalDate.now())
				.endDate(LocalDate.now()).build();
	}

}
