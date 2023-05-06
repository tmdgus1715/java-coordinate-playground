package coordinatecalculator.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureGenerator {

    private static final Map<Integer, Function<List<Point>, Figure>> figureInventory;

    static {
        figureInventory = new HashMap<>();
        figureInventory.put(2, StraightLine::getInstance);
        figureInventory.put(3, Triangle::getInstance);
        figureInventory.put(4, Rectangle::getInstance);
    }
    private FigureGenerator() {
    }

    public static Figure generate(List<Point> points) {
        return figureInventory.get(points.size()).apply(points);
    }
}
