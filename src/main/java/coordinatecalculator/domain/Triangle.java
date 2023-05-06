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
}
