package com.crudops.reactiveapp.dao;

import com.crudops.reactiveapp.model.EmployeeModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeInterface {
    Mono<EmployeeModel> findByName(String name);

    Mono<EmployeeModel> save(EmployeeModel employee);

    Flux<EmployeeModel> findAll();

    Mono<Void> deleteById(String id);

    Mono<EmployeeModel> updateSalary(EmployeeModel employee);

}
