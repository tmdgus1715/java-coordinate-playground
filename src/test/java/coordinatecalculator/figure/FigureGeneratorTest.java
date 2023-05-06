package coordinatecalculator.figure;

import coordinatecalculator.domain.*;
import coordinatecalculator.exception.DuplicatePointException;
import coordinatecalculator.exception.InvalidRectanglePointException;
import coordinatecalculator.exception.InvalidTrianglePointException;
import coordinatecalculator.exception.NoMatchFigureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FigureGeneratorTest {

    @Test
    @DisplayName("좌표가 2개가 주어지면 직선 생성")
    void straightline_generate() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2));

        Figure figure = FigureGenerator.generate(points);

        assertThat(figure).isInstanceOf(StraightLine.class);
    }

    @Test
    @DisplayName("좌표가 3개가 주어지면 삼각형 생성")
    void triangle_generate() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2), new Point(6, 1));

        Figure figure = FigureGenerator.generate(points);

        assertThat(figure).isInstanceOf(Triangle.class);
    }

    @Test
    @DisplayName("좌표가 4개가 주어지면 사각형 생성")
    void rectangle_generate() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2), new Point(1, 4), new Point(5, 4));

        Figure figure = FigureGenerator.generate(points);

        assertThat(figure).isInstanceOf(Rectangle.class);
    }

    @Test
    @DisplayName("좌표가 한개 또는 5개 이상 주어지면 예외 발생")
    void no_match_figure() {
        List<Point> points1 = Arrays.asList(new Point(1, 2));
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2), new Point(1, 4), new Point(5, 4), new Point(9, 7));

        assertThatThrownBy(() -> FigureGenerator.generate(points)).isInstanceOf(NoMatchFigureException.class);
    }

    @Test
    @DisplayName("좌표가 3개가 주어지더라도 일직선 상에 있으면 예외 발생")
    void unable_to_generate_triangle() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2), new Point(3, 2));

        assertThatThrownBy(() -> FigureGenerator.generate(points)).isInstanceOf(InvalidTrianglePointException.class);
    }

    @Test
    @DisplayName("좌표가 4개가 주어지더라도 직사각형이 아니면 예외 발생")
    void unable_to_generate_rectangle() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(5, 2), new Point(1, 7), new Point(5, 3));

        assertThatThrownBy(() -> FigureGenerator.generate(points)).isInstanceOf(InvalidRectanglePointException.class);
    }

    @Test
    @DisplayName("좌표중 중복이 있으면 예외 발생")
    void check_duplicate_point() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(1, 2));

        assertThatThrownBy(() -> FigureGenerator.generate(points)).isInstanceOf(DuplicatePointException.class);
    }

    @Test
    @DisplayName("좌표를 입력하지 않으면 예외 발생")
    void check_null_point() {
        List<Point> points = null;

        assertThatThrownBy(() -> FigureGenerator.generate(points)).isInstanceOf(NullPointerException.class);
    }
}
