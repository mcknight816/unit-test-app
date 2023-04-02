package com.example.unit_test_app.service;

import com.example.unit_test_app.model.UnitTestEntity;
import com.example.unit_test_app.repository.UnitTestEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class UnitTestEntityService{

  private final UnitTestEntityRepo repo;

  public UnitTestEntityService(UnitTestEntityRepo repo) {
    this.repo = repo;
  }

  public Mono<UnitTestEntity> save(UnitTestEntity item) {
    return repo.save(item);
  }

  public Mono<Void> deleteById(String id) {
    return repo.deleteById(id);
  }

  public Mono<UnitTestEntity> findById(String id) {
    return repo.findById(id);
  }

  public Flux<UnitTestEntity> findAll() {
    return repo.findAll();
  }

  public Flux<UnitTestEntity> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAllBy(pageable);
  }

}
