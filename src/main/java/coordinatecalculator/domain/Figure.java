package coordinatecalculator.domain;

import java.util.List;

public interface Figure {

    void checkGenerable(List<Point> points);

    double getArea();
}
