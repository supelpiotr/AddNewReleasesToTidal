package pl.coderslab.app.exceptions;

public class UncheckedUnirestException extends RuntimeException {

    public UncheckedUnirestException() {
    }

    public UncheckedUnirestException(String message) {
        super(message);
    }

    public UncheckedUnirestException(Throwable cause) {
        super(cause);
    }
}
