package com.crudops.reactiveapp.controller;

import com.crudops.reactiveapp.model.EmployeeModel;
import com.crudops.reactiveapp.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeServiceImpl employeeService;

    @GetMapping(path = "/find/{name}")
    public Mono<EmployeeModel> findByName(@PathVariable String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/find")
    public Flux<EmployeeModel> findAllEmployee() {
        return employeeService.findAll();
    }

    @PostMapping(path = "/save")
    public Mono<EmployeeModel> saveEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.save(employee);
    }

    @PutMapping(path = "/update")
    public Mono<EmployeeModel> updateSalary(@RequestBody EmployeeModel employee){
        return employeeService.updateSalary(employee);
    }
    @DeleteMapping(path = "/delete/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return employeeService.deleteById(id);
    }



}
