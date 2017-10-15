package world;

import model.Event;
import util.Constants;
import util.DistanceComparator;
import util.RandomGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class World {

    private Map<Integer, Point> eventsMap;

    public World() {
        eventsMap = new HashMap<>();

        assignRandomEventsToRandomPoints();
    }

    public int numberOfEvents() {
        return eventsMap.size();
    }

    public Map<Integer,Point> eventsMap() {
        return eventsMap;
    }

    public void addEvent(Event e) {
        Point point = RandomGenerator.generatePoint();

        while (eventsMap.containsKey(point.hashCode()))
            point = RandomGenerator.generatePoint();

        point.setEvent(e);
        eventsMap.put(point.hashCode(), point);
    }

    public void printNearestNumberEvents(int x, int y) {
        if (isOutsideGridBoundaries(x, y))
            throw new IllegalArgumentException("Out of grid boundaries.");

        Point[] nearestNumberPoints = getNearestNumberEvents(new Point(x, y));

        if (nearestNumberPoints[0] == null)
            System.out.println("No events nearby!\n");
        else
            for (Point p : nearestNumberPoints)
                if (p != null)
                    System.out.println(p + "\n");
    }

    public Point[] getNearestNumberEvents(Point start) {
        Point[] pointArr = new Point[Constants.NUMBER_OF_NEAREST_EVENTS];
        PriorityQueue<Point> pq = getNearestEvents(start);

        for (int i=0; i<pointArr.length; i++)
            pointArr[i] = pq.poll();

        return pointArr;
    }

    private PriorityQueue<Point> getNearestEvents(Point start) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Constants.NUMBER_OF_NEAREST_EVENTS, new DistanceComparator(start));

        for (int key : eventsMap.keySet())
            if (key != start.hashCode())
                pq.add(eventsMap.get(key));

        return pq;
    }

    private boolean isOutsideGridBoundaries(int x, int y) {
        return Math.abs(x) > Constants.GRID_SIZE ||
               Math.abs(y) > Constants.GRID_SIZE;
    }

    private void assignRandomEventsToRandomPoints() {
        for (Event e : RandomGenerator.generateEventList())
            addEvent(e);
    }
}

