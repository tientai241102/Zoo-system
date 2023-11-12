package com.codegym.service;



import com.codegym.model.history.HistoryTransaction;
import com.codegym.model.history.HistoryType;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.visitors.Adult;
import com.codegym.model.person.visitors.Child;
import com.codegym.model.person.visitors.Senior;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.model.ticket.AdultTicket;
import com.codegym.model.ticket.ChildTicket;
import com.codegym.model.ticket.SeniorTicket;
import com.codegym.repository.VisitorRepository;

import java.sql.Date;
import java.util.List;

public class VisitorService extends BaseService{

    private static VisitorService visitorService;



    private VisitorService() {

    }

    public static VisitorService getVisitorService(){
        if (visitorService == null){
            visitorService = new VisitorService();
        }
        return visitorService;
    }
    private VisitorRepository visitorRepository =  VisitorRepository.getVisitorRepository();

    private HistoryTransactionService historyTransactionService = HistoryTransactionService.getHistoryTransactionService();


    public List<Visitor> getVisitors(){
        return visitorRepository.getAllVisitors();
    }

    public  List<Visitor>  findById(AgeCategory ageCategory){
        return visitorRepository.findVisitorsByAgeCategory(ageCategory);
    }
    public void addVisitor(Visitor visitor) {
        visitorRepository.addVisitor(visitor);
          double totalMoney;
        if(visitor instanceof Child){
           totalMoney = ((Child) visitor).getChildTicket().getPrice();
        } else if(visitor instanceof Adult){
            totalMoney = ((Adult) visitor).getAdultTicket().getPrice();
        } else {
            totalMoney = ((Senior) visitor).getSeniorTicket().getPrice();
        }

        historyTransactionService.addHistoryTransaction(new HistoryTransaction( genId(),visitor.getVisitorID(), HistoryType.BUY_TICKET,totalMoney,new Date(System.currentTimeMillis())));
    }
    public void updateVisitor(Visitor visitor) {
        visitorRepository.updateVisitor(visitor);
    }


    
}
