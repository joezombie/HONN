package is.ru.honn.ruber.rides.service;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public class TripExistsException extends RuntimeException
{
    public TripExistsException() {
    }

    public TripExistsException(String message) {
        super(message);
    }

    public TripExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TripExistsException(Throwable cause) {
        super(cause);
    }
}

