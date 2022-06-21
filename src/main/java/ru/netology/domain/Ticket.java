package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int flightDuration;

    public Ticket(int id, int price, String departureAirport, String arrivalAirport, int flightDuration) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightDuration = flightDuration;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public boolean match(String from, String to) {
        return (departureAirport.contains(from) && arrivalAirport.contains(to));
    }

    @Override
    public int compareTo(Ticket ticket) {
        if (price < ticket.price) {
            return -1;
        }
        if (price > ticket.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return price == ticket.price && flightDuration == ticket.flightDuration && Objects.equals(id, ticket.id) && Objects.equals(departureAirport, ticket.departureAirport) && Objects.equals(arrivalAirport, ticket.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departureAirport, arrivalAirport, flightDuration);
    }
}