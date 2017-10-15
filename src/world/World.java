package world;

import model.Event;
import util.Constants;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class World {

    private Map<Integer, Point> map;

    public World() {
        map = new HashMap<Integer, Point>();
        List<Event> eventList = RandomGenerator.generateEventList();

        for (Event e : eventList)
            addEvent(e);
    }

    private void addEvent(Event e) {
        Point point = RandomGenerator.generatePoint();

        while (map.containsKey(point.hashCode()))
            point = RandomGenerator.generatePoint();

        point.setEvent(e);
        map.put(point.hashCode(), point);
    }

    public void getNearestN(int x, int y) {

        if (Math.abs(x) > Constants.GRID_SIZE ||
            Math.abs(y) > Constants.GRID_SIZE)
            throw new IllegalArgumentException("Out of grid boundaries.");

        List<Point> nearestPoints = nearestNHelper(new Point(x, y));

        for (Point p : nearestPoints)
            System.out.println(p);
    }

    private List<Point> nearestNHelper(Point start) {
        Comparator<Point> distanceComparator = new DistanceComparator(start);
        PriorityQueue<Point> pq = new PriorityQueue<>(Constants.NUMBER_OF_NEAREST_EVENTS, distanceComparator);

        for (int key : map.keySet())
            if (key != start.hashCode())
                pq.add(map.get(key));

        List<Point> list = new ArrayList<>();

        while (list.size() < Constants.NUMBER_OF_NEAREST_EVENTS)
            list.add(pq.poll());

        return list;
    }
}

class DistanceComparator implements Comparator<Point>{

    private Point start;

    DistanceComparator(Point start) {
        this.start = start;
    }

    @Override
    public int compare(Point a, Point b) {
        int aDist = start.distanceTo(a);
        int bDist = start.distanceTo(b);

        a.setDistance(aDist);
        b.setDistance(bDist);

        return Integer.compare(aDist, bDist);
    }
}