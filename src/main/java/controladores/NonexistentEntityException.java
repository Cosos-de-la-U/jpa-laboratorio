package controladores;

public class NonexistentEntityException extends Exception {

    public NonexistentEntityException() {
        super();
    }

    public NonexistentEntityException(String message) {
        super(message);
    }

    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonexistentEntityException(Throwable cause) {
        super(cause);
    }
}
