package ru.netology.repository;

import ru.netology.domain.Ticket;

import java.util.Objects;

public class Repository {

    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void saveTicket(Ticket ticket) {
        if (findById(ticket.getId()) != null) {
            throw new AlreadyExistsException("Element with id " + ticket.getId() + " already exists");
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tickets.length] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int index = 0;
        Ticket[] tmp = new Ticket[tickets.length - 1];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getId() != id) {
                tmp[index] = tickets[i];
                index++;
            }
        }
        tickets = tmp;
    }
}