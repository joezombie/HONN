package is.ru.honn.ruber.drivers.service;

/**
 * Created by Johannes Gunnar Heidarsson on 27.10.2014.
 */
public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException() {
    }

    public DriverNotFoundException(String message) {
        super(message);
    }

    public DriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverNotFoundException(Throwable cause) {
        super(cause);
    }
}
