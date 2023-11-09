package com.codegym.repository;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.serializer.ReadCustomerSerializer;
import com.codegym.serializer.ReadEmployeeSerializer;


import java.util.ArrayList;
import java.util.List;

public class VisitorRepository {

    private List<Visitor> visitors;


    public VisitorRepository() {
        visitors = new ArrayList<>();
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public List<Visitor> findVisitorsByAgeCategory(AgeCategory ageCategory) {
        List<Visitor> matchingVisitors = new ArrayList<>();
        for (Visitor visitor : visitors) {
            if (visitor.getAgeCategory() == ageCategory) {
                matchingVisitors.add(visitor);
            }
        }
        return matchingVisitors;
    }

    public List<Visitor> getAllVisitors() {
        return visitors;
    }

    public void updateVisitor(Visitor updatedVisitor) {
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getVisitorID().equals(updatedVisitor.getVisitorID())) {
                visitors.set(i, updatedVisitor);
                return;
            }
        }
    }

    private void updateFileCSV(){
        ReadCustomerSerializer readCustomerSerializer=    ReadCustomerSerializer.getInstanceReadCustomerSerializer();
        readCustomerSerializer.writeToCSV(visitors);
    }
}
