package com.gml.client.application.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDto {

	private String sharedKey;

	private String name;

	private LocalDate bindingDate;

	private String mail;

	private String phone;
}
