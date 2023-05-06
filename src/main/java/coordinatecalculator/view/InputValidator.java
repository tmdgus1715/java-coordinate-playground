package coordinatecalculator.view;

import coordinatecalculator.exception.InvalidInputFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static final String INPUT_FORMAT_ERROR_MESSAGE = "잘못된 형식입니다. 좌표 정보는 괄호\"(\", \")\"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분합니다.";
    public static final String POINT_REGEX = "(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}";

    public static void checkValidFormat(String input) {
        Pattern pattern = Pattern.compile(POINT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidInputFormatException(INPUT_FORMAT_ERROR_MESSAGE);
        }
    }
}
