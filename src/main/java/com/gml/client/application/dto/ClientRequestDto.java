package com.gml.client.application.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequestDto {

	private String name;

	private LocalDate startDate;
	
	private LocalDate endDate;

	private String mail;

	private String phone;
}
