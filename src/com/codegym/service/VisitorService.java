package com.codegym.service;



import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.repository.VisitorRepository;

import java.util.List;

public class VisitorService {
    private VisitorRepository visitorRepository = new VisitorRepository();


    public List<Visitor> getVisitors(){
        return visitorRepository.getAllVisitors();
    }

    public  List<Visitor>  findById(AgeCategory ageCategory){
        return visitorRepository.findVisitorsByAgeCategory(ageCategory);
    }
    public void addVisitor(Visitor visitor) {
        visitorRepository.addVisitor(visitor);
    }
    public void updateVisitor(Visitor visitor) {
        visitorRepository.updateVisitor(visitor);
    }


    
}
