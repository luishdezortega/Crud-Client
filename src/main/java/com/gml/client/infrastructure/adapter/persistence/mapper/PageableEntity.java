package com.gml.client.infrastructure.adapter.persistence.mapper;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageableEntity<T> {

	private Long totalElements;

	private Integer totalPages;

	private List<T> entity;

}
