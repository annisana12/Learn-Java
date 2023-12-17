package belajar_package.error;

public class ValidationException extends Throwable {
    public ValidationException(String message) {
        super(message);
    }
}
