package unittests.util;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstantsTest {
    private static int testGridSize;

    @Before
    public void setUp() {
        testGridSize = 10;
    }

    @Test
    public void doesCalculateProperRowColumnLength() {
        Assert.assertEquals(testGridSize*2 + 1, 21);
    }

    @Test
    public void doesCalculateProperMaxNumberOfEvents() {
        Assert.assertEquals(((testGridSize*2)+1)*((testGridSize*2)+1), 441);
    }
}
