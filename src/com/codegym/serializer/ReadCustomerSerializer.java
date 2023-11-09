package com.codegym.serializer;


import com.codegym.model.person.visitors.Visitor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReadCustomerSerializer {

    private static ReadCustomerSerializer readCustomerSerializer;

    public  static ReadCustomerSerializer getInstanceReadCustomerSerializer(){
        if (readCustomerSerializer == null){
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
                        obj.getCity()+ "," +
                        obj.getCountry()+ "," +
                        obj.getGender()+ "," +
                        obj.getAge()+ "," +
                        obj.getVisitorID()+ "," +
                        obj.getAgeCategory()
                );

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
