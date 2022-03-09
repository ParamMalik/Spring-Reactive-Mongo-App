package com.crudops.reactiveapp.controller;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import com.crudops.reactiveapp.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping(path = "/find/{name}")
    public Mono<EmployeeDTO> findByName(@PathVariable String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/find")
    public Flux<EmployeeDTO> findAllEmployee() {
        return employeeService.findAll();
    }

    @PostMapping(path = "/save")
    public Mono<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employee) {

        return employeeService.save(employee);
    }

    @PutMapping(path = "/update")
    public Mono<EmployeeDTO> updateSalary(@RequestBody EmployeeDTO employee) {
        return employeeService.updateSalary(employee);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return employeeService.deleteById(id);
    }

//    @PatchMapping("/partialUpdate")
//    public Mono<EmployeeDTO> partialUpdate(@RequestBody EmployeeDTO employeeDTO) {
//        return employeeService.partialUpdate(employeeDTO);
//    }


}
