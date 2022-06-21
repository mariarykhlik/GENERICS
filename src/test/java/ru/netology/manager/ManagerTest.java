package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    Ticket ticket1 = new Ticket(1, 10000, "LED", "AER", 100);
    Ticket ticket2 = new Ticket(2, 2000, "LED", "SVO", 90);
    Ticket ticket3 = new Ticket(3, 5000, "LED", "AER", 120);
    Ticket ticket4 = new Ticket(4, 8000, "LED", "AER", 105);
    Ticket ticket5 = new Ticket(5, 4500, "LED", "KRR", 125);
    Ticket ticket6 = new Ticket(6, 10000, "LED", "AER", 99);

    Repository repository = new Repository();
    Manager manager = new Manager(repository);

    @Test
    public void shouldAddTicket() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket3);
        manager.addTicket(ticket2);

        Ticket[] expected = {ticket1, ticket3, ticket2};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTickets() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findTickets("LED", "AER");

        Ticket[] expected = {ticket3, ticket4, ticket1, ticket6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNotFrom() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);

        Ticket[] actual = manager.findTickets("AER", "SVO");

        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNotTo() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);

        Ticket[] actual = manager.findTickets("LED", "MOW");

        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] actual = manager.findAll("LED", "AER", new TicketByPriceAscComparator());
        Ticket[] expected = {ticket3, ticket4, ticket1, ticket6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothingFrom() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);

        Ticket[] actual = manager.findAll("AER", "SVO", new TicketByPriceAscComparator());

        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothingTo() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);

        Ticket[] actual = manager.findAll("LED", "MOW", new TicketByPriceAscComparator());

        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}