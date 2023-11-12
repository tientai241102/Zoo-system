package com.codegym.model.ticket;

import com.codegym.model.ticket.enumerations.Date;

public class ChildTicket implements Ticket{
    @Override
    public double getPrice() {
        return 40000;
    }
    @Override
    public String toString() {
        return ", ChildTicket=" + getPrice() +
                '}';
    }
}
