package model;

import java.util.List;
import java.util.PriorityQueue;

public class Event {
    private int id;
    private PriorityQueue<Ticket> ticketsList;

    public Event(int id, List<Ticket> ticketList) {
        this.id = id;
        this.ticketsList = new PriorityQueue<>(ticketList);
    }

    public void addTicket(Ticket t) {
        ticketsList.add(t);
    }

    public int id() {
        return id;
    }

    public Ticket cheapestTicket() {
        return ticketsList.peek();
    }

    @Override
    public String toString() {
        return id + "";
    }
}
