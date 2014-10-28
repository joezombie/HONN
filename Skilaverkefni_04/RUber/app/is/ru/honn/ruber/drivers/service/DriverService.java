package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 27.10.2014.
 */
public interface DriverService {
    public List<Driver> getAllDrivers();
    public Driver getDriverById(Integer id);
}
