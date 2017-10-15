package unittests.world;

import junit.framework.Assert;
import model.Event;
import model.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import util.Constants;
import world.Point;
import world.World;

public class WorldTest {

    private static World world;

    @Mock
    private Event mockedEvent = Mockito.mock(Event.class);

    @Mock
    private Ticket mockedTicket = Mockito.mock(Ticket.class);

    @Mock
    private Point mockedPoint = Mockito.mock(Point.class);

    @Before
    public void setUp() {
        world = new World();

        when(mockedPoint.toString()).thenReturn("MockedPoint");
    }

    @Test
    public void doesAddEventsToPoints() {
        int prevNumOfEvents = world.numberOfEvents();
        world.addEvent(mockedEvent);
        Assert.assertTrue(world.numberOfEvents() > prevNumOfEvents);
    }

    @Test
    public void doesFindNearestNumberOfEventsWhenMoreThanNEvents() {
        world.eventsMap().clear();

        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);

        Assert.assertEquals(world.getNearestNumberEvents(mockedPoint).length, Constants.NUMBER_OF_NEAREST_EVENTS);
    }

    @Test
    public void doesFindNearestNumberOfEventsWhenLessThanNEvents() {
        world.eventsMap().clear();

        world.addEvent(mockedEvent);
        world.addEvent(mockedEvent);

        Assert.assertEquals(world.getNearestNumberEvents(mockedPoint).length, Constants.NUMBER_OF_NEAREST_EVENTS);
        Assert.assertNotNull(world.getNearestNumberEvents(mockedPoint)[0]);
        Assert.assertNotNull(world.getNearestNumberEvents(mockedPoint)[1]);
        Assert.assertNull(world.getNearestNumberEvents(mockedPoint)[2]);
        Assert.assertNull(world.getNearestNumberEvents(mockedPoint)[3]);
        Assert.assertNull(world.getNearestNumberEvents(mockedPoint)[4]);
    }
}
