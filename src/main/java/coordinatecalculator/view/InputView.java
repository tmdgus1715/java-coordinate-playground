package coordinatecalculator.view;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.Point;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String INPUT_MESSAGE = "좌표를 입력하세요.";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<Point> input() {
        printInputMessage();
        String input = scanner.nextLine();

        try {
            InputValidator.checkValidFormat(input);

        } catch (Exception e) {
            return input();
        }
        return DataConvertor.toPoint(input);
    }

    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }
}
