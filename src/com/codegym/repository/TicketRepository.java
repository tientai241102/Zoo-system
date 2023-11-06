package com.codegym.repository;

import com.codegym.model.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private List<Ticket> tickets;

    public TicketRepository() {
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public Ticket findById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticketId == ticket.getPrice()) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public void updateTicket(Ticket updatedTicket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getPrice() == updatedTicket.getPrice()) {
                tickets.set(i, updatedTicket);
                return;
            }
        }
    }
}
