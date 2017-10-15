package util;

import world.Point;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Point> {
    private Point start;

    public DistanceComparator(Point start) {
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
