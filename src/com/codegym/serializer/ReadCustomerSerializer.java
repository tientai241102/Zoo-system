package com.codegym.serializer;


import com.codegym.model.person.employee.Accountant;
import com.codegym.model.person.employee.Employee;
import com.codegym.model.person.employee.Owner;
import com.codegym.model.person.employee.Supplier;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.person.visitors.Adult;
import com.codegym.model.person.visitors.Child;
import com.codegym.model.person.visitors.Senior;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.model.ticket.AdultTicket;
import com.codegym.model.ticket.ChildTicket;
import com.codegym.model.ticket.SeniorTicket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerSerializer {

    private static ReadCustomerSerializer readCustomerSerializer;

    public static ReadCustomerSerializer getInstanceReadCustomerSerializer() {
        if (readCustomerSerializer == null) {
            readCustomerSerializer = new ReadCustomerSerializer();
        }
        return readCustomerSerializer;
    }


    private ReadCustomerSerializer() {
    }

    public void writeToCSV(List<Visitor> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("visitor.csv"))) {
            writer.println("Name,Street, City,Country,Gender,Age,Visitor ID,Age Category");
            for (Visitor obj : objects) {
                writer.println(obj.getName() + "," +
                        obj.getStreetAddress() + "," +
                        obj.getCity() + "," +
                        obj.getCountry() + "," +
                        obj.getGender() + "," +
                        obj.getAge() + "," +
                        obj.getVisitorID() + "," +
                        obj.getAgeCategory()
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Visitor> readFromCSV() {
        List<Visitor> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("visitor.csv"))) {
            String line;
            Boolean co = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && co) {
                    String name = data[0];
                    String streetAddress = data[1];
                    String city = data[2];
                    String country = data[3];
                    GenderPerson gender = GenderPerson.valueOf(data[4]);
                    int age = Integer.valueOf(data[5]);
                    String visitorId = data[6];
                    AgeCategory ageCategory = AgeCategory.valueOf(data[7]);
                    Visitor visitor;
                    if (age <= 12) {
                        visitor = new Child(name, streetAddress, city, country, gender, age, visitorId, ageCategory, new ChildTicket());
                    } else if (age <= 64) {
                        visitor = new Adult(name, streetAddress, city, country, gender, age, visitorId, ageCategory, new AdultTicket());
                    } else {
                        visitor = new Senior(name, streetAddress, city, country, gender, age, visitorId, ageCategory, new SeniorTicket());
                    }

                    loadedObjects.add(visitor);
                }
                co = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }
}
