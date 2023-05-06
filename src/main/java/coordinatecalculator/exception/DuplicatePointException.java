package coordinatecalculator.exception;

public class DuplicatePointException extends RuntimeException {

    public DuplicatePointException() {
    }

    public DuplicatePointException(String message) {
        super(message);
    }
}
