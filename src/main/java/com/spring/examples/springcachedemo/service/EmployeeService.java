package com.spring.examples.springcachedemo.service;

import com.spring.examples.springcachedemo.entity.Employee;

public interface EmployeeService {

    public void addInitData();
    public void addEmployee(Employee e);
    public Employee getEmployee(int id) throws InterruptedException;
}
