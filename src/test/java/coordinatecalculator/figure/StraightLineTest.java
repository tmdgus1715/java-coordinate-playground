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
import static org.assertj.core.api.Assertions.offset;

public class StraightLineTest {

    @Test
    @DisplayName("2개의 좌표가 주어졌을 때 2개의 좌표가 형성하는 직선의 길이를 반환")
    void StraightLine_area() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(3, 4));
        Figure straightLine = FigureGenerator.generate(points);

        assertThat(straightLine.getArea()).isEqualTo(2.82828282, offset(0.00099));
    }
}
