package ru.netology.domain;

import java.util.Comparator;
import java.util.Objects;

public class TicketByPriceAscComparator implements Comparator<Ticket> {

    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int flightDuration;

    public TicketByPriceAscComparator() {

    }

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getPrice() - o2.getPrice();
    }
}