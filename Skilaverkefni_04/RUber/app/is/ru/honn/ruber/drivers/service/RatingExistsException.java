package is.ru.honn.ruber.drivers.service;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class RatingExistsException extends RuntimeException {
    public RatingExistsException() {
    }

    public RatingExistsException(String message) {
        super(message);
    }

    public RatingExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RatingExistsException(Throwable cause) {
        super(cause);
    }
}
