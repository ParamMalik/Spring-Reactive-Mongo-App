package com.crudops.reactiveapp.service;

import com.crudops.reactiveapp.model.EmployeeModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeModel> findByName(String name);

    Mono<EmployeeModel> save(EmployeeModel employee);

    Flux<EmployeeModel> findAll();

    Mono<Void> deleteById(String id);

    Mono<EmployeeModel> updateSalary(EmployeeModel employee);

}
