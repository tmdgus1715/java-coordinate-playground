package coordinatecalculator.domain;

import java.util.List;

public class StraightLine implements Figure {

    private final List<Point> points;

    private StraightLine(List<Point> points) {
        this.points = points;
    }

    public static Figure getInstance(List<Point> points) {
        return new StraightLine(points);
    }

    @Override
    public void checkGenerable(List<Point> points) {
    }

    @Override
    public double getArea() {
        Point p1 = points.get(0);
        Point p2 = points.get(1);

        return p1.getDistance(p2);
    }
}
