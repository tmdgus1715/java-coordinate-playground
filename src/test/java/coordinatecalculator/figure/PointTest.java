package coordinatecalculator.figure;

import coordinatecalculator.domain.Point;
import coordinatecalculator.exception.PointRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PointTest {

    @ParameterizedTest
    @DisplayName("x와 y값은 둘 다 양수가 아니면 예외 발생")
    @CsvSource(value = {"0,0", "1,0", "0,1", "1,-1", "-1,1", "-1,-1"}, delimiter = ',')
    void point_range_positive(int x, int y) {
        assertThatThrownBy(() -> new Point(x, y)).isInstanceOf(PointRangeException.class);
    }

    @ParameterizedTest
    @DisplayName("x와 y값은 둘 다 24이하가 아니면 예외 발생")
    @CsvSource(value = {"20,25", "25,20", "25,25"}, delimiter = ',')
    void point_range_lower_24(int x, int y) {
        assertThatThrownBy(() -> new Point(x, y)).isInstanceOf(PointRangeException.class);
    }

    @Test
    @DisplayName("x와 y값이 둘 다 양수이고, 24이하이면 좌표 생성")
    void point_create() {
        Point point = new Point(1, 24);

        assertThat(point.getX()).isEqualTo(1);
        assertThat(point.getY()).isEqualTo(24);
    }

    @Test
    @DisplayName("x와 y값이 같으면 같은 좌표")
    void equals() {
        Point point1 = new Point(1, 24);
        Point point2 = new Point(1, 24);
        Point point3 = new Point(24, 1);

        assertThat(point1.equals(point2)).isTrue();
        assertThat(point1.equals(point3)).isFalse();
    }
}
