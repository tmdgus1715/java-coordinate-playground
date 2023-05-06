package coordinatecalculator.domain;

import coordinatecalculator.exception.InvalidTrianglePointException;

import java.util.List;

public class Triangle implements Figure {

    private final List<Point> points;

    private Triangle(List<Point> points) {
        checkGenerable(points);
        this.points = points;
    }

    public static Figure getInstance(List<Point> points) {
        return new Triangle(points);
    }

    @Override
    public void checkGenerable(List<Point> points) {
        points.sort(Point::compareTo);
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);

        if ((p2.getX() - p1.getX()) * (p3.getY() - p2.getY()) == (p2.getY() - p1.getY()) * (p3.getX() - p2.getX())) {
            throw new InvalidTrianglePointException("주어진 좌표로 삼각형을 만들 수 없습니다.");
        }
    }

    @Override
    public double getArea() {
        double line1 = points.get(0).getDistance(points.get(1));
        double line2 = points.get(0).getDistance(points.get(2));
        double line3 = points.get(1).getDistance(points.get(2));

        return formulaOfHeron(line1, line2, line3);
    }

    private double formulaOfHeron(double line1, double line2, double line3) {
        double s = 0.5 * (line1 + line2 + line3);

        return Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));
    }
}
