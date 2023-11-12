package com.codegym.model.ticket;

public class SeniorTicket implements Ticket{
    @Override
    public double getPrice() {
        return 50000;
    }
    @Override
    public String toString() {
        return ", SeniorTicket=" + getPrice() +
                '}';
    }
}
