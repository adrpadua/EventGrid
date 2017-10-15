package unittests.util;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import util.DistanceComparator;
import world.Point;

public class DistanceComparatorTest {

    private static DistanceComparator distanceComparator;

    private Point p1;
    private Point p2;
    private Point p3;

    @Before
    public void setUp() {
        p1 = new Point(0, 0);
        p2 = new Point(1, 1);
        p3 = new Point(2, 2);

        distanceComparator = new DistanceComparator(p1);
    }

    @Test
    public void doesReturnEqualToValue() {
        Assert.assertEquals(distanceComparator.compare(p1, p1), 0);
    }

    @Test
    public void doesReturnGreaterThanValue() {
        Assert.assertEquals(distanceComparator.compare(p3, p2), 1);
    }

    @Test
    public void doesReturnLessThanValue() {
        Assert.assertEquals(distanceComparator.compare(p2, p3), -1);
    }
}
