package com.crudops.reactiveapp.dao;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeInterface {
    Mono<EmployeeDTO> findById(String id);

    Mono<EmployeeDTO> save(EmployeeDTO employee);

    Flux<EmployeeDTO> findAll();

    Mono<Void> deleteById(String id);

    Mono<EmployeeDTO> updateSalary(EmployeeDTO employee);

//    Mono<EmployeeDTO> partialUpdate(EmployeeDTO employeeDTO);

}
