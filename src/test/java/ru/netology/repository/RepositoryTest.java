package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    Ticket ticket1 = new Ticket(1, 5000, "LED", "AER", 120);
    Ticket ticket2 = new Ticket(2, 2000, "LED", "SVO", 90);
    Ticket ticket3 = new Ticket(3, 10000, "LED", "OVB", 480);
    Ticket ticket4 = new Ticket(4, 8000, "LED", "SVX", 350);
    Ticket ticket5 = new Ticket(5, 4500, "LED", "KRR", 110);

    Repository repository = new Repository();

    @Test
    public void shouldRemoveById() {

        repository.saveTicket(ticket1);
        repository.saveTicket(ticket2);
        repository.saveTicket(ticket3);
        repository.saveTicket(ticket4);
        repository.saveTicket(ticket5);

        repository.removeById(3);

        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAlreadyExistsException() {

        repository.saveTicket(ticket1);
        repository.saveTicket(ticket2);

        assertThrows(AlreadyExistsException.class, () -> {
            repository.saveTicket(ticket1);
        });
    }

    @Test
    public void shouldThrowNotFoundException() {

        repository.saveTicket(ticket1);
        repository.saveTicket(ticket2);


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}