package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ruframework.data.RuData;
import is.ruframework.data.RuDataAccess;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public interface DriverDataGateway extends RuDataAccess {
    public int addDriver(Driver driver);
    public Driver getDriverById(Integer id);
}
