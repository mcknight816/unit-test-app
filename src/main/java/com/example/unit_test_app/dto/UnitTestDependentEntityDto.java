package com.example.unit_test_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitTestDependentEntityDto {

	private Long count;
	private Double multiplier;
}