package com.codegym.service;


import com.codegym.model.person.employee.Employee;
import com.codegym.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {



    private EmployeeRepository employeeRepository = new EmployeeRepository();
    public List<Employee> getEmployees(){
        return employeeRepository.getAllEmployees();
    }

    public Employee findById(String employeeId){
        return employeeRepository.findEmployeeById(employeeId);
    }
    public  List<Employee> findByName(String employeeName){
        return employeeRepository.findEmployeesByName(employeeName);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public void removeEmployee(String employeeId) {
        employeeRepository.removeEmployee(employeeId);
    }
}
