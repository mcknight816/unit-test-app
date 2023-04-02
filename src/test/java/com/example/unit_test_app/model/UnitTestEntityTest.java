package com.example.unit_test_app.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class UnitTestEntityTest {

  @Test
  void shouldCreateUnitTestEntity(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(UnitTestEntity.class));
  }

  @Test
  void shouldBuildUnitTestEntity(){
    Assertions.assertNotNull(UnitTestEntity.builder().build());
  }
}
