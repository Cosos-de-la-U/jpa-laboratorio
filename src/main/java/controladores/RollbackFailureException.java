package controladores;

public class RollbackFailureException extends Exception {

    public RollbackFailureException() {
        super();
    }

    public RollbackFailureException(String message) {
        super(message);
    }

    public RollbackFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public RollbackFailureException(Throwable cause) {
        super(cause);
    }
}
