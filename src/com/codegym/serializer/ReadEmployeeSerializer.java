package com.codegym.serializer;

import com.codegym.model.person.Person;
import com.codegym.model.person.employee.Accountant;
import com.codegym.model.person.employee.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReadEmployeeSerializer {
    private static ReadEmployeeSerializer readEmployeeSerializer;

    public static ReadEmployeeSerializer getInstanceReadEmployeeSerializer() {
        if (readEmployeeSerializer == null) {
            readEmployeeSerializer = new ReadEmployeeSerializer();
        }
        return readEmployeeSerializer;
    }


    private ReadEmployeeSerializer() {
    }

    public void writeToCSV(List<Employee> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("employee.csv"))) {
            writer.println("Name,Street, City,Country,Gender,Age,Employee Id,Job Position,Salary,Role,Total Revenue");
            for (Employee obj : objects) {
                if (obj instanceof Accountant) {
                    writer.println(obj.getName() + "," +
                            obj.getStreetAddress() + "," +
                            obj.getCity() + "," +
                            obj.getCountry() + "," +
                            obj.getGender() + "," +
                            obj.getAge() +
                            obj.getEmployeeId() + "," +
                            obj.getJobPosition() + "," +
                            obj.getSalary() + "," +
                            obj.getRole() + "," +
                            ((Accountant) obj).getTotalRevenue()
                    );
                } else {
                    writer.println(obj.getName() + "," +
                            obj.getStreetAddress() + "," +
                            obj.getCity() + "," +
                            obj.getCountry() + "," +
                            obj.getGender() + "," +
                            obj.getAge() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getJobPosition() + "," +
                            obj.getSalary() + "," +
                            obj.getRole() + "," + " "
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
