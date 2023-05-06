package coordinatecalculator.view;

import coordinatecalculator.domain.Figure;

public class OutputView {

    public static final String OUTPUT_MESSAGE = "두 점 사이의 거리는 : ";

    public void output(Figure figure) {
        System.out.println(OUTPUT_MESSAGE + figure.getArea());
    }
}
