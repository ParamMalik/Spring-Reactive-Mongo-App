package com.crudops.reactiveapp.service;

import com.crudops.reactiveapp.dao.EmployeeDAOImpl;
import com.crudops.reactiveapp.dao.EmployeeInterface;
import com.crudops.reactiveapp.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
    @Autowired
    public EmployeeDAOImpl employeeDAO;

    @Override
    public Mono<EmployeeModel> findByName(String name) {
        return employeeDAO.findByName(name);
    }

    @Override
    public Mono<EmployeeModel> save(EmployeeModel employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Flux<EmployeeModel> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return employeeDAO.deleteById(id);
    }

    @Override
    public Mono<EmployeeModel> updateSalary(EmployeeModel employee) {
        return employeeDAO.updateSalary(employee);
    }
}
