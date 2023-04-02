package com.example.unit_test_app.repository;

import reactor.core.publisher.Flux;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.unit_test_app.model.UnitTestEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitTestEntityRepo extends ReactiveMongoRepository<UnitTestEntity, String> {

	Flux<UnitTestEntity> findAllBy(Pageable pageable);
}