package unittests.model;

import junit.framework.Assert;
import model.Event;
import model.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EventTest {

    private static Event event;

    @Test
    public void doesReturnCorrectID() {
        Assert.assertEquals(event.id(), 1);
    }

    @Test
    public void doesReturnCorrectNumberOfTickets() {
        Assert.assertEquals(event.numTickets(), 5);
    }

    @Test
    public void doesReturnCheapestTicket() {
        Assert.assertEquals(event.cheapestTicket().price(), 1.0);
    }

    @Test
    public void doesAddNewTicket() {
        event.addTicket(new Ticket(6.0));
        Assert.assertEquals(event.numTickets(), 6);
    }

    @Before
    public void setUp() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket(1.0));
        ticketList.add(new Ticket(2.0));
        ticketList.add(new Ticket(3.0));
        ticketList.add(new Ticket(4.0));
        ticketList.add(new Ticket(5.0));

        event = new Event(1, ticketList);
    }
}
