package unittests.world;

import junit.framework.Assert;
import model.Event;
import model.Ticket;
import org.junit.Before;
import org.junit.Test;
import world.Point;

import java.util.ArrayList;
import java.util.List;

public class PointTest {

    private static Point point;

    @Before
    public void setUp(){
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket(1.0));
        ticketList.add(new Ticket(2.0));
        ticketList.add(new Ticket(3.0));
        ticketList.add(new Ticket(4.0));
        ticketList.add(new Ticket(5.0));
        Event event = new Event(1, ticketList);

        point = new Point(0, 0);
        point.setEvent(event);
    }

    @Test
    public void doesReturnCorrectCoordinates() {
        Assert.assertEquals(point.x(), 0);
        Assert.assertEquals(point.y(), 0);
    }

    @Test
    public void doesReturnCorrectDistances() {
        Assert.assertEquals(point.distanceTo(new Point(1,1)), 2);
        Assert.assertEquals(point.distanceTo(new Point(2,1)), 3);
        Assert.assertEquals(point.distanceTo(new Point(1,2)), 3);
        Assert.assertEquals(point.distanceTo(new Point(2,2)), 4);
        Assert.assertEquals(point.distanceTo(new Point(3,3)), 6);
        Assert.assertEquals(point.distanceTo(new Point(5,5)), 10);
    }

    @Test
    public void doesSetProperEvent() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket(6.0));
        ticketList.add(new Ticket(7.0));
        ticketList.add(new Ticket(8.0));
        ticketList.add(new Ticket(9.0));
        ticketList.add(new Ticket(10.0));
        Event newEvent = new Event(2, ticketList);

        point.setEvent(newEvent);

        Assert.assertEquals(point.event().id(), 2);
        Assert.assertEquals(point.event().cheapestTicket().price(), 6.0);
    }
}
