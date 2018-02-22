package com.spring.examples.springcachedemo.service;

import com.spring.examples.springcachedemo.entity.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void addInitData() {
        Employee e1 = new Employee(1, "Jack");
        Employee e2 = new Employee(2, "Tom");
        Employee e3 = new Employee(3, "Leo");

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
    }

    @Override
    public void addEmployee(Employee e) {
        employeeList.add(e);
    }

    @Override
    @Cacheable("Employee")
    public Employee getEmployee(int id) throws InterruptedException {
        delay();
        Optional<Employee> empResult = employeeList.stream().filter(e -> e.getId() == id).findFirst();
        if(empResult.isPresent()) {
            System.out.println(empResult.get());
            return empResult.get();
        }
        return null;
    }

    public void delay() throws InterruptedException {
        Thread.sleep(2000L);
    }
}
