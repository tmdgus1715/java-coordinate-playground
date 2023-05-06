package coordinatecalculator.domain;

import coordinatecalculator.exception.InvalidRectanglePointException;
import coordinatecalculator.exception.InvalidTrianglePointException;

import java.util.List;

public class Rectangle implements Figure {

    private final List<Point> points;

    private Rectangle(List<Point> points) {
        checkGenerable(points);
        this.points = points;
    }

    public static Figure getInstance(List<Point> points) {
        return new Rectangle(points);
    }

    @Override
    public void checkGenerable(List<Point> points) {
        points.sort(Point::compareTo);
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);

        boolean line1 = p1.getY() == p3.getY() && p1.getX() != p3.getX();
        boolean line2 = p2.getY() == p4.getY() && p2.getX() != p4.getX();
        boolean line3 = p1.getX() == p2.getX() && p1.getY() != p2.getY();

        if (!(line1 && line2 && line3)) {
            throw new InvalidRectanglePointException("주어진 좌표로 밑변의 기울기가 0인 직사각형을 만들 수 없습니다.");
        }
    }
}
