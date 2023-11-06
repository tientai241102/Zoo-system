package com.codegym.model.person.visitors;

import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;

public class Visitor extends Person {
    private String visitorID;
    private AgeCategory ageCategory;

    public Visitor(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String visitorID, AgeCategory ageCategory) {
        super(name, streetAddress, city, country, gender, age);
        this.visitorID = visitorID;
        this.ageCategory = ageCategory;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(String visitorID) {
        this.visitorID = visitorID;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", streetAddress='" + getStreetAddress() + '\'' +
                ", city='" + getCity() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", gender=" + getGender() +
                ", age=" + getAge() +
                ", visitorID =" + visitorID +
                ", ageCategory=" + ageCategory ;
    }
}
