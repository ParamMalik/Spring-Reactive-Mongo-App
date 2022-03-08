package com.crudops.reactiveapp.dao;

import com.crudops.reactiveapp.model.EmployeeModel;
import com.crudops.reactiveapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EmployeeDAOImpl implements EmployeeInterface {

    @Autowired
    public EmployeeRepository employeeRepository;


    // Find Emp Details By Name

    @Override
    public Mono<EmployeeModel> findByName(String name) {

        return employeeRepository.findByName(name);
    }

    // Add Employee to the database
    @Override
    public Mono<EmployeeModel> save(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }


    // Get All Employee from the database
    @Override
    public Flux<EmployeeModel> findAll() {
        return employeeRepository.findAll();
    }

    // Detele Employee Using id from database
    @Override
    public Mono<Void> deleteById(String id) {
        return employeeRepository.deleteById(id);
    }

    // Update Salary using name
    @Override
    public Mono<EmployeeModel> updateSalary(EmployeeModel employee) {
        return employeeRepository.findByName(employee.getName()).defaultIfEmpty(employee)
                .map(e -> {
                    e.setSalary(employee.getSalary());
                    return e;
                })
                .flatMap(employeeRepository::save);

    }
}
