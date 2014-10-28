package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverRating;
import is.ru.honn.ruber.domain.Product;
import is.ruframework.data.RuData;
import is.ruframework.data.RuDataAccess;
import scala.Int;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public interface DriverDataGateway extends RuDataAccess {
    public int addDriver(Driver driver);
    public List<Driver> getAllDrivers();
    public Driver getDriverById(Integer id);
    public Product getProduct(Integer id);
    public List<DriverRating> getRatingForDriver(Integer id);
    public DriverRating addRatingForDriver(DriverRating rating);
}
