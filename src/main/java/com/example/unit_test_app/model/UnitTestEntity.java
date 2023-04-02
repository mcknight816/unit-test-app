package com.example.unit_test_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class UnitTestEntity {

	@Id
	private String id;
	private String name;
	private Integer age;
	private BigDecimal price;
	private Instant created;
	private UnitTestDependentEntity dependentEntity;
	private List<String> hobbies;
	private String owner;
}