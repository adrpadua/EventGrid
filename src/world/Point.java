package world;

import model.Event;
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

    public Event event() {
        return event;
    }

    public int x() {
        return coordinates[0];
    }

    public int y() {
        return coordinates[1];
    }

    public int distanceTo(Point p) {
        return Math.abs(x() - p.x()) + Math.abs(y() - p.y());
    }

    public void setEvent(Event e) {
        this.event = e;
    }

    public void setDistance(int d) {
        this.distanceFromStart = d;
    }

    @Override
    public String toString() {
        return "Event " + event + " - " + event.cheapestTicket() + ", Distance " + distanceFromStart;
    }

    @Override
    public int hashCode() {
        int result = x();
        result = 31 * result + y();
        return result;
    }

}
