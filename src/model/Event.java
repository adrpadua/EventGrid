package model;

import java.util.List;
import java.util.PriorityQueue;

public class Event {
    private int id;
    private int numTickets;
    private PriorityQueue<Ticket> ticketsList;

    public Event(int id, List<Ticket> ticketList) {
        this.id = id;
        this.numTickets = 0;
        this.ticketsList = new PriorityQueue<>(ticketList);
        this.numTickets = ticketList.size();
    }

    public void addTicket(Ticket t) {
        ticketsList.add(t);
        numTickets++;
    }

    public int numTickets() {
        return numTickets;
    }

    public int id() {
        return id;
    }

    public Ticket cheapestTicket() {
        return ticketsList.peek();
    }

    @Override
    public String toString() {
        return String.format("%03d", id);
    }
}
