package com.codegym.model.person.employee;

import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.GenderPerson;

public class  Owner extends Employee {


    private double totalMoney;

    public Owner(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String employeeId, String jobPosition, double salary,String username, String password, double totalMoney) {
        super(name, streetAddress, city, country, gender, age, employeeId, jobPosition, salary,"Owner", username,password);
        this.totalMoney = totalMoney;

    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return super.toString() +"------" +
                "totalMoney=" + totalMoney ;
    }
}