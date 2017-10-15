package unittests.model;

import junit.framework.Assert;
import model.Ticket;
import org.junit.Before;
import org.junit.Test;

public class TicketTest {

    private static Ticket ticket;

    @Before
    public void setUp() {
        ticket = new Ticket(1.0);
    }

    @Test
    public void doesReturnCorrectPrice() {
        Assert.assertEquals(ticket.price(), 1.0);
    }

    @Test
    public void doesReturnUSDFormatting() {
        Assert.assertEquals(ticket.toString(), "$1.00");
    }

    @Test
    public void doesCompareCorrectlyToLowerPrice() {
        Assert.assertTrue(ticket.compareTo(new Ticket(0.5)) > 0);
    }

    @Test
    public void doesCompareCorrectlyToHigherPrice() {
        Assert.assertTrue(ticket.compareTo(new Ticket(1.5)) < 0);
    }

    @Test
    public void doesCompareCorrectlyToEqualPrice() {
        Assert.assertTrue(ticket.compareTo(new Ticket(1.0)) == 0);
    }
}
