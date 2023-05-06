package coordinatecalculator.domain;

import coordinatecalculator.exception.PointRangeException;

public class Point {
    public static final String POINT_RANGE_ERROR_MESSAGE = "잘못된 범위의 좌푯값입니다.";
    private final int x;
    private final int y;

    public Point(int x, int y) {
        validRange(x, y);
        this.x = x;
        this.y = y;
    }

    private void validRange(int x, int y) {
        if (x <= 0 || x > 24 || y <= 0 || y > 24) {
            throw new PointRangeException(POINT_RANGE_ERROR_MESSAGE);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Point p = (Point) obj;
            return this.x == p.getX() && this.y == p.getY();
        } catch (Exception e) {
            return false;
        }
    }
}
