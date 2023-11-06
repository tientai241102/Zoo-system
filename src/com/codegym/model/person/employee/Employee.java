package com.codegym.model.person.employee;

import com.codegym.model.Cage.Cage;
import com.codegym.model.Cage.enumerations.CleanlinessEnclosure;
import com.codegym.model.animal.Animal;
import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.GenderPerson;

public class Employee extends Person {
    private String employeeId;
    private String jobPosition;
    private double salary;

    public Employee(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String employeeId, String jobPosition, double salary) {
        super(name, streetAddress, city, country, gender, age);
        this.employeeId = employeeId;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String examineEnclosure(Cage cage) {
        if (cage == null) {
            throw new IllegalArgumentException("Chuồng phải chứa động vật.");
        }
        if (cage.getCleanliness() == CleanlinessEnclosure.CLEAN) {
            return "Chuồng sạch sẽ.";
        } else if (cage.getCleanliness() == CleanlinessEnclosure.NORMAL) {
            return "Mức độ sạch của chuồng là bình thường.";
        } else {
            return "Chuồng đang dơ bẩn và cần phải được vệ sinh.";
        }
    }

    public String cleanEnclosure(Cage cage) {
        if (cage == null) {
            throw new IllegalArgumentException("Chuồng phải chứa động vật.");
        }
        cage.setCleanliness(CleanlinessEnclosure.CLEAN);
        return "Chuồng đã được vệ sinh.";
    }

    public void feedAnimalsEnclosure(Cage cage) {
        if (cage == null) {
            throw new IllegalArgumentException("Chuồng phải chứa động vật.");
        }
        for (Animal animal : cage.getAnimals()) {
            animal.setHungry(false);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", salary=" + salary +
                '}';
    }
}
