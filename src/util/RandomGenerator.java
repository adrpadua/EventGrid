package util;

import model.Event;
import model.Ticket;
import world.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RandomGenerator {
    private static Random rand = new Random();

    public static Point generatePoint() {
        int randX = generateOrdinate();
        int randY = generateOrdinate();

        return new Point(randX, randY);
    }

    public static List<Event> generateEventList() {
        int numEvents = generateNumberOfEvents();
        List<Event> eventList = new ArrayList<>();

        for (int i = 1; i <= numEvents; i++)
            eventList.add(new Event(i, generateTicketList()));

        return eventList;
    }

    private static int generateOrdinate() {
        return rand.nextInt(Constants.ROW_COL_LENGTH) - Constants.GRID_SIZE;
    }

    private static int generateNumberOfEvents() {
        return rand.nextInt(Constants.MAX_NUM_EVENTS);
    }

    private static List<Ticket> generateTicketList() {
        List<Ticket> ticketsList = new ArrayList<>();
        int numTickets = generateNumberOfTickets();

        for (int i=0; i< numTickets; i++) {
            ticketsList.add(new Ticket(generateTicketPrice()));
        }

        return ticketsList;
    }

    private static int generateNumberOfTickets() {
        return rand.nextInt(Constants.MAX_NUM_TICKETS_PER_EVENT);
    }

    private static double generateTicketPrice() {
        double dollarVal = rand.nextInt(Constants.MAX_TICKET_PRICE);
        double centsVal = rand.nextInt(Constants.CENTS_PER_DOLLAR+1) / 100.0;

        double price = dollarVal + centsVal;

        if (price == 0.0)
            return generateTicketPrice();

        return dollarVal + centsVal;
    }
}
