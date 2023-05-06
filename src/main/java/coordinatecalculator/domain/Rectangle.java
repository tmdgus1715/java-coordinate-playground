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

        boolean line1 = p1.isEqualYAxis(p3) && !p1.isEqualXAxis(p3);
        boolean line2 = p2.isEqualYAxis(p4) && !p2.isEqualXAxis(p4);
        boolean line3 = p1.isEqualXAxis(p2) && !p1.isEqualYAxis(p2);

        if (!(line1 && line2 && line3)) {
            throw new InvalidRectanglePointException("주어진 좌표로 밑변의 기울기가 0인 직사각형을 만들 수 없습니다.");
        }
    }

    @Override
    public double getArea() {
        return 0.0;
    }
}
