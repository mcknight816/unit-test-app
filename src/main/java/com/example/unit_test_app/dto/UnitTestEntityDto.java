package com.example.unit_test_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitTestEntityDto {

	private String id;
	private String name;
	private Integer age;
	private BigDecimal price;
	private Instant created;
	private UnitTestDependentEntityDto dependentEntity;
	private List<String> hobbies;
	private String owner;
}