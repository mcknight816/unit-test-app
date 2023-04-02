package com.example.unit_test_app.controller;

import com.example.unit_test_app.model.UnitTestEntity;
import com.example.unit_test_app.service.UnitTestEntityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.any;
import java.util.List;
import org.skyscreamer.jsonassert.JSONAssert;

@WebFluxTest(controllers = UnitTestEntityController.class)
@Import(UnitTestEntityService.class)
@ExtendWith(SpringExtension.class)
@Scope("test")
class UnitTestEntityControllerTest {

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  UnitTestEntityService service;

  @Autowired
  private UnitTestEntityController controller;

  Mono<UnitTestEntity> mono;
  Flux<UnitTestEntity> flux;

  @BeforeEach
  void before() {
  EasyRandomParameters parameters = new EasyRandomParameters();
  parameters.setCollectionSizeRange(new EasyRandomParameters.Range<>(2,10));
  EasyRandom generator = new EasyRandom(parameters);

  mono = Mono.just(generator.nextObject(UnitTestEntity.class));
    flux = Flux.just(generator.nextObject(UnitTestEntity.class), generator.nextObject(UnitTestEntity.class));
    Mockito.when(this.service.findAll()).thenReturn(flux);
    Mockito.when(this.service.save(any())).thenReturn(mono);
    Mockito.when(this.service.findById(any())).thenReturn(mono);
  }

  @Test
  void shouldFindById() throws Exception {
    String jsonBlob = objectMapper.writeValueAsString(mono.block());
    byte[] data = WebTestClient.bindToController(controller).build()
      .get().uri("/rest/unitTestEntity/1")
      .exchange()
      .expectStatus().isOk()
      .expectHeader().contentType(MediaType.APPLICATION_JSON)
      .expectBody().returnResult().getResponseBody();
       JSONAssert.assertEquals(jsonBlob, objectMapper.writeValueAsString(objectMapper.readValue(data,UnitTestEntity.class)),false);
  }

  @Test
  void shouldFindAll() throws Exception {
    String jsonBlob = objectMapper.writeValueAsString(flux.collectList().block());
    byte[] data = WebTestClient.bindToController(controller).build()
      .get().uri("/rest/unitTestEntity")
      .exchange()
      .expectStatus().isOk()
      .expectHeader().contentType(MediaType.APPLICATION_JSON)
      .expectBody().returnResult().getResponseBody();

    assert (flux.collectList().block().size() == objectMapper.readValue(data, List.class).size());
  }

  @Test
  void shouldDeleteById() {
    WebTestClient
      .bindToController(controller)
      .build()
      .delete().uri("/rest/unitTestEntity/1")
      .exchange()
      .expectStatus().isOk();
  }

  @Test
  void shouldSave() throws Exception {
    String jsonBlob = objectMapper.writeValueAsString(mono.block());
     byte[] data = WebTestClient.bindToController(controller).build()
      .post().uri("/rest/unitTestEntity")
      .body(mono,UnitTestEntity.class)
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectHeader().contentType(MediaType.APPLICATION_JSON)
      .expectBody().returnResult().getResponseBody();

     JSONAssert.assertEquals(jsonBlob, objectMapper.writeValueAsString(objectMapper.readValue(data,UnitTestEntity.class)),false);
  }
}
