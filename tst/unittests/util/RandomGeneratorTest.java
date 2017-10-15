package unittests.util;

import junit.framework.Assert;
import model.Event;
import org.junit.Test;
import util.Constants;
import util.RandomGenerator;
import world.Point;

import java.util.List;

public class RandomGeneratorTest {

    @Test
    public void doesGeneratePointsWithinGrid() {
        int numPoints = 100;
        boolean result = true;

        for (int i=0; i<numPoints; i++) {
            Point p = RandomGenerator.generatePoint();

            if (Math.abs(p.x()) > Constants.GRID_SIZE ||
                Math.abs(p.y()) > Constants.GRID_SIZE) {
                result = false;
                break;
            }
        }

        Assert.assertTrue(result);
    }

    @Test
    public void doesGeneratePoint() {
        Point p = RandomGenerator.generatePoint();

        Assert.assertNotNull(p);
    }

    @Test
    public void doesGenerateEventList() {
        List<Event> eventList= RandomGenerator.generateEventList();

        Assert.assertNotNull(eventList);
    }
}
