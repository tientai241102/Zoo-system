package com.codegym.repository;

import com.codegym.model.person.employee.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private List<Employee> employees;



    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
    }

    public Employee findEmployeeById(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findEmployeesByName(String name) {
        List<Employee> matchingEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(updatedEmployee.getEmployeeId())) {
                employees.set(i, updatedEmployee);
                return;
            }
        }
    }
}
