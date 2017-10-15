package world;

import model.Event;
import model.Ticket;

import java.util.Arrays;
import java.util.Collections;

public class Point {
    private int[] coordinates;
    private int distanceFromStart;
    private Event event;

    public Point(int x, int y) {
        coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        event = new Event(Integer.MAX_VALUE, Collections.emptyList());
    }

    public int distanceTo(Point p) {
        return Math.abs(x() - p.x()) + Math.abs(y() - p.y());
    }

    void setEvent(Event e) {
        this.event = e;
    }

    void setDistance(int d) {
        this.distanceFromStart = d;
    }

    @Override
    public String toString() {
        return "Event " + event.id() + " - " + event.cheapestTicket() + ", Distance " + distanceFromStart;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!Point.class.isAssignableFrom(obj.getClass()))
            return false;

        final Point other = (Point) obj;

        return this.coordinates == other.coordinates;
    }

    @Override
    public int hashCode() {
        int result = x();
        result = 31 * result + y();
        return result;
    }

    private int x() {
        return coordinates[0];
    }
    private int y() {
        return coordinates[1];
    }
}
