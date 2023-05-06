package coordinatecalculator.view;

import coordinatecalculator.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataConvertor {

    public static final String PARSE_REGEX = "[\\(\\)\\,\\-]";

    public static List<Point> toPoint(String input) {
        int[] splited = Stream.of(input.replaceAll(PARSE_REGEX, "").split(""))
                .mapToInt(Integer::parseInt).toArray();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < splited.length - 1; i += 2) {
            points.add(new Point(splited[i], splited[i + 1]));
        }

        return points;
    }
}
