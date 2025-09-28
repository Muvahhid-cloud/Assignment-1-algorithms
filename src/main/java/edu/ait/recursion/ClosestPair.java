package edu.ait.recursion;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    public record Point(double x, double y) {}

    public static double closestPair(Point[] points) {
        Point[] px = Arrays.copyOf(points, points.length);
        Arrays.sort(px, Comparator.comparingDouble(p -> p.x));
        Point[] py = Arrays.copyOf(px, px.length);
        Arrays.sort(py, Comparator.comparingDouble(p -> p.y));
        return closest(px, py);
    }

    private static double closest(Point[] px, Point[] py) {
        int n = px.length;
        if (n <= 3) return bruteForce(px);
        int mid = n / 2;
        Point midPoint = px[mid];

        Point[] Qx = Arrays.copyOfRange(px, 0, mid);
        Point[] Rx = Arrays.copyOfRange(px, mid, n);

        Point[] Qy = Arrays.stream(py).filter(p -> p.x <= midPoint.x).toArray(Point[]::new);
        Point[] Ry = Arrays.stream(py).filter(p -> p.x > midPoint.x).toArray(Point[]::new);

        double d1 = closest(Qx, Qy);
        double d2 = closest(Rx, Ry);
        double d = Math.min(d1, d2);

        return Math.min(d, stripClosest(py, midPoint.x, d));
    }

    private static double bruteForce(Point[] pts) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < pts.length; i++) {
            for (int j = i + 1; j < pts.length; j++) {
                min = Math.min(min, dist(pts[i], pts[j]));
            }
        }
        return min;
    }

    private static double stripClosest(Point[] py, double midX, double d) {
        Point[] strip = Arrays.stream(py).filter(p -> Math.abs(p.x - midX) < d).toArray(Point[]::new);
        double min = d;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
                min = Math.min(min, dist(strip[i], strip[j]));
            }
        }
        return min;
    }

    private static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}
