package com.crudops.reactiveapp.repository;

import com.crudops.reactiveapp.model.EmployeeModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<EmployeeModel, String> {
    Mono<EmployeeModel> findByName(String name);

}
