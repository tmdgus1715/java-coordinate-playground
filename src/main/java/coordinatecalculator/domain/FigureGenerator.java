package coordinatecalculator.domain;

import coordinatecalculator.exception.DuplicatePointException;
import coordinatecalculator.exception.NoMatchFigureException;

import java.util.*;

public class FigureGenerator {

    private static final Map<Integer, FigureGenerateFunction<List<Point>, Figure>> figureInventory;

    static {
        figureInventory = new HashMap<>();
        figureInventory.put(2, StraightLine::getInstance);
        figureInventory.put(3, Triangle::getInstance);
        figureInventory.put(4, Rectangle::getInstance);
    }
    private FigureGenerator() {
    }

    public static Figure generate(List<Point> points) {
        if (points == null) {
            throw new NullPointerException("유효한 도형을 만들기 위해서는 좌표를 입력해야 합니다.");
        }
        checkAvailableFigure(points.size());
        checkDuplicatePoint(points);

        return figureInventory.get(points.size()).generate(points);
    }

    public static void checkAvailableFigure(int numberOfPoint) {
        if (!figureInventory.containsKey(numberOfPoint)) {
            throw new NoMatchFigureException("유효한 도형을 만들기 위한 좌표의 개수는 2개 이상 4개 이하입니다.");
        }
    }

    public static void checkDuplicatePoint(List<Point> points) {
        Set<Point> verifier = new HashSet<>(points);

        if (verifier.size() != points.size()) {
            throw new DuplicatePointException("중복된 좌표는 허용되지 않습니다.");
        }
    }
}
