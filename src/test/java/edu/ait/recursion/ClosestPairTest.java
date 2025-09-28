package edu.ait.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {
    @Test
    public void testSimplePoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(3,4),
                new ClosestPair.Point(1,1)
        };
        double d = ClosestPair.closestPair(pts);
        assertEquals(Math.sqrt(2), d, 1e-9);
    }

    @Test
    public void testRandomPointsVsBruteForce() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(0,1),
                new ClosestPair.Point(0,2),
                new ClosestPair.Point(2,2)
        };
        double d = ClosestPair.closestPair(pts);
        assertEquals(1.0, d, 1e-9);
    }
}
