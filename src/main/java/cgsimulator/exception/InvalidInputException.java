package cgsimulator.exception;

public class InvalidInputException extends Exception {

    public InvalidInputException(String input, Throwable cause) {
        super(input + " is not a valid command", cause);
    }
}
