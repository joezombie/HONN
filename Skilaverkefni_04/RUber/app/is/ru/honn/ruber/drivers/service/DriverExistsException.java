package is.ru.honn.ruber.drivers.service;

/**
 * Created by Johannes Gunnar Heidarsson on 27.10.2014.
 */
public class DriverExistsException extends RuntimeException {
    public DriverExistsException() {
    }

    public DriverExistsException(String message) {
        super(message);
    }

    public DriverExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverExistsException(Throwable cause) {
        super(cause);
    }
}
