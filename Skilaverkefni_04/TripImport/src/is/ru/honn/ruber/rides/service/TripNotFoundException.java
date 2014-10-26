package is.ru.honn.ruber.rides.service;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException() {
    }

    public TripNotFoundException(String message) {
        super(message);
    }

    public TripNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TripNotFoundException(Throwable cause) {
        super(cause);
    }
}
