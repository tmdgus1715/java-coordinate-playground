package coordinatecalculator.figure;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.FigureGenerator;
import coordinatecalculator.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {

    @Test
    @DisplayName("3개의 좌표가 주어졌을 때 좌표가 형성하는 도형의 넓이를 반환하면 참")
    void rectangle_area() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2), new Point(1, 7));
        Figure rectangle = FigureGenerator.generate(points);

        assertThat(rectangle.getArea()).isEqualTo(10.0, offset(0.00099));
    }
}
