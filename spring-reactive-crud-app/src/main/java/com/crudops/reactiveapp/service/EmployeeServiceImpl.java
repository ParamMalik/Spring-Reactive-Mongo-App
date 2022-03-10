package com.crudops.reactiveapp.service;

import com.crudops.reactiveapp.dao.EmployeeDAOImpl;
import com.crudops.reactiveapp.dao.EmployeeInterface;
import com.crudops.reactiveapp.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
    @Autowired
    public EmployeeDAOImpl employeeDAO;

    @Override
    public Mono<EmployeeDTO> findById(String name) {
        return employeeDAO.findById(name);
    }

    @Override
    public Mono<EmployeeDTO> save(EmployeeDTO employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Flux<EmployeeDTO> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return employeeDAO.deleteById(id);
    }

    @Override
    public Mono<EmployeeDTO> updateSalary(EmployeeDTO employee) {
        return employeeDAO.updateSalary(employee);
    }

//    public Mono<EmployeeDTO> partialUpdate(EmployeeDTO employeeDTO){
//        return employeeDAO.partialUpdate(employeeDTO);
//    }
}
