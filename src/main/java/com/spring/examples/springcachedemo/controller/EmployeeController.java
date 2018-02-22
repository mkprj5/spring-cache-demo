package com.spring.examples.springcachedemo.controller;

import com.spring.examples.springcachedemo.entity.Employee;
import com.spring.examples.springcachedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) throws InterruptedException {
        return employeeService.getEmployee(id);
    }

    @GetMapping("employee/add")
    public void addEmployeeData() {
        employeeService.addInitData();
    }
}
