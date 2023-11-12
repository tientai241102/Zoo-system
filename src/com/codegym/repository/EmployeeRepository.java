package com.codegym.repository;

import com.codegym.model.person.employee.Employee;
import com.codegym.serializer.ReadEmployeeSerializer;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private List<Employee> employees;



    private static EmployeeRepository employeeRepository;

    private EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    public static EmployeeRepository getEmployeeRepository(){
        if (employeeRepository == null){
            employeeRepository = new EmployeeRepository();
        }
        return employeeRepository;
    }




    public void addEmployee(Employee employee) {
        employees.add(employee);
        updateFileCSV();
    }

    public void removeEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
        updateFileCSV();
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
                updateFileCSV();
                return;
            }
        }
    }

    private void updateFileCSV(){
        ReadEmployeeSerializer readEmployeeSerializer=    ReadEmployeeSerializer.getInstanceReadEmployeeSerializer();
        readEmployeeSerializer.writeToCSV(employees);
    }
}
