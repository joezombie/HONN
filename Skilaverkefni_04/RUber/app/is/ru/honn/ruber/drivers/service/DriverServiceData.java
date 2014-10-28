package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverRating;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.drivers.data.DriverData;
import is.ruframework.data.RuData;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 27.10.2014.
 */
public class DriverServiceData extends RuData implements DriverService {
    private DriverData driverData;

    public DriverServiceData(DriverData driverData) {
        this.driverData = driverData;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverData.getAllDrivers();
    }

    @Override
    public Driver getDriverById(Integer id) {
        return driverData.getDriverById(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return driverData.getProduct(id);
    }

    @Override
    public List<DriverRating> getRatingForDriver(Integer id) {
        return driverData.getRatingForDriver(id);
    }

    @Override
    public DriverRating addRating(DriverRating rating) {
        return driverData.addRatingForDriver(rating);
    }
}
