package coordinatecalculator.figure;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.FigureGenerator;
import coordinatecalculator.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {

    @Test
    @DisplayName("4개의 좌표가 주어졌을 때 좌표가 형성하는 도형의 넓이를 반환하면 참")
    void rectangle_area() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2), new Point(1, 4), new Point(5, 4));
        Figure rectangle = FigureGenerator.generate(points);

        assertThat(rectangle.getArea()).isEqualTo(8);
    }
}
