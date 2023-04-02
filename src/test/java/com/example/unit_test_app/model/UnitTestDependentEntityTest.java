package com.example.unit_test_app.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class UnitTestDependentEntityTest {

  @Test
  void shouldCreateUnitTestDependentEntity(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(UnitTestDependentEntity.class));
  }

  @Test
  void shouldBuildUnitTestDependentEntity(){
    Assertions.assertNotNull(UnitTestDependentEntity.builder().build());
  }
}
