package com.example.unit_test_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitTestDependentEntity {

	private Long count;
	private Double multiplier;
}