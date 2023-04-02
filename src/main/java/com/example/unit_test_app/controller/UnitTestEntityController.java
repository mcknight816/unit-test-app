package com.example.unit_test_app.controller;

import com.example.unit_test_app.service.UnitTestEntityService;
import com.example.unit_test_app.dto.UnitTestEntityDto;
import com.example.unit_test_app.mapping.UnitTestEntityMapper;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class UnitTestEntityController {

  private final  UnitTestEntityService service;

  public  UnitTestEntityController(UnitTestEntityService service) {
    this.service = service;
  }

  @PostMapping(value="/unitTestEntity",produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UnitTestEntityDto> save(@RequestBody UnitTestEntityDto dto){
    return this.service.save(UnitTestEntityMapper.MAPPER.unitTestEntityDtoToUnitTestEntity(dto)).map(UnitTestEntityMapper.MAPPER::unitTestEntityToUnitTestEntityDto);
  }

  @GetMapping(value = "/unitTestEntity/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<UnitTestEntityDto> findById(@PathVariable("id") String id ){
    return this.service.findById(String.valueOf(id)).map(UnitTestEntityMapper.MAPPER::unitTestEntityToUnitTestEntityDto);
  }

  @GetMapping(value = "/unitTestEntity",produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<UnitTestEntityDto> findAll(){
    return this.service.findAll().map(UnitTestEntityMapper.MAPPER::unitTestEntityToUnitTestEntityDto);
  }

  @DeleteMapping(value = "/unitTestEntity/{id}")
  public Mono<Void> deleteById(@PathVariable("id") String id ){
    return this.service.deleteById(String.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/unitTestEntity/search"}, produces = { "application/json" })
  public Flux<UnitTestEntityDto> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
          return this.service.search(searchTerm,PageRequest.of(page,limit)).map(UnitTestEntityMapper.MAPPER::unitTestEntityToUnitTestEntityDto);
  }

}
