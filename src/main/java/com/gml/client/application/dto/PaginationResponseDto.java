package com.gml.client.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationResponseDto<T> {

	private Long numberOfElements;

	private Integer numberOfPages;

	private List<T> responseDto;
}
