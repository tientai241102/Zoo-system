package com.codegym.model.person;

import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.GenderPerson;

public class  Owner extends Person {
    private double accountBalance;

    public Owner(String name, String streetAddress, String city, String country, GenderPerson gender, int age, double accountBalance) {
        super(name, streetAddress, city, country, gender, age);
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void receiveTransactionNotification(String supplierName, double amount) {
        this.accountBalance -= amount;
        System.out.println("Chủ sở hữu " + getName() + " đã nhận thông báo giao dịch từ " + supplierName + " với số tiền là " + amount);
    }
}