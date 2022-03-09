package com.crudops.reactiveapp.service;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeDTO> findByName(String name);

    Mono<EmployeeDTO> save(EmployeeDTO employee);

    Flux<EmployeeDTO> findAll();

    Mono<Void> deleteById(String id);

    Mono<EmployeeDTO> updateSalary(EmployeeDTO employee);

//    Mono<EmployeeDTO> partialUpdate(EmployeeDTO employee);

}
