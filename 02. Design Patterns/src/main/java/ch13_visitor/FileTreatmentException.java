package ch13_visitor;

public class FileTreatmentException extends RuntimeException {

    public FileTreatmentException() {
        this("FileTreatmentException");
    }

    public FileTreatmentException(String message) {
        super(message);
    }
}
