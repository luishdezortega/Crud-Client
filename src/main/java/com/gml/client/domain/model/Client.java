package com.gml.client.domain.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

	private String sharedKey;

	private String name;

	private LocalDate startDate;

	private LocalDate endDate;

	private LocalDate bindingDate;

	private String mail;

	private String phone;
}
