package coordinatecalculator.controller;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.FigureGenerator;
import coordinatecalculator.domain.Point;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

import java.util.List;

public class CoordinateCalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CoordinateCalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<Point> points = inputView.input();
        Figure figure = FigureGenerator.generate(points);
        outputView.output(figure);
    }
}
