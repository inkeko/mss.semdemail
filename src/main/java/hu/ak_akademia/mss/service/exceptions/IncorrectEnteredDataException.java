package hu.ak_akademia.mss.service.exceptions;

public class IncorrectEnteredDataException extends Exception {

    private String errorMessage;

    public IncorrectEnteredDataException() {
        super();
    }

    public IncorrectEnteredDataException(String message) {
        super(message);
    }

    public IncorrectEnteredDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectEnteredDataException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
