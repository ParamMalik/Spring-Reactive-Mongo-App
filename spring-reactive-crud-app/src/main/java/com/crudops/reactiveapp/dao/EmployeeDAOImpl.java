package com.crudops.reactiveapp.dao;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import com.crudops.reactiveapp.mapper.EmployeeMapper;
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
    public Mono<EmployeeDTO> findByName(String name) {

        return employeeRepository.findByName(name);
    }

    // Add Employee to the database
    @Override
    public Mono<EmployeeDTO> save(EmployeeDTO employee) {

        return employeeRepository.save(EmployeeMapper.INSTANCE.toEmployeeModel(employee)).map(EmployeeMapper.INSTANCE::toEmployeeDTO);
    }


    // Get All Employee from the database
    @Override
    public Flux<EmployeeDTO> findAll() {
        return employeeRepository.findAll().map(EmployeeMapper.INSTANCE::toEmployeeDTO);
    }

    // Delete Employee Using id from database
    @Override
    public Mono<Void> deleteById(String id) {
        return employeeRepository.deleteById(id);
    }

    // Update Salary using name
    @Override
    public Mono<EmployeeDTO> updateSalary(EmployeeDTO employee) {

        return employeeRepository.findByName(employee.getName()).map(e -> {
            e.setSalary(employee.getSalary());
            return e;
        }).map(EmployeeMapper.INSTANCE::toEmployeeModel).flatMap(employeeRepository::save).map(EmployeeMapper.INSTANCE::toEmployeeDTO);


    }

//    public Mono<EmployeeDTO> partialUpdate(EmployeeDTO employeeDTO) {
//
//        //   System.out.println(employeeModel.getName());
//
//          employeeRepository.findById(employeeDTO.getId()).subscribe(x -> {
//            EmployeeModel employeeModel = new EmployeeModel();
//            employeeModel.setId(x.getId());
//            employeeModel.setName(x.getName());
//            employeeModel.setSalary(x.getSalary());
//            employeeModel.setStreet(x.getStreet());
//            employeeModel.setCity(x.getCity());
//            EmployeeMapper.INSTANCE.updateEmployeeFromDto(employeeDTO, employeeModel);
//
//            employeeRepository.save(employeeModel);
//
//
//        });
//        return null;
//    }
}

