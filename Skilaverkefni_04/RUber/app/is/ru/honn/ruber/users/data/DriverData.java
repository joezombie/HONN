package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.Driver;
import is.ruframework.data.RuData;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway {
    @Override
    public int addDriver(Driver driver) {
        return 0;
    }

    @Override
    public Driver getDriverById(int id) {
        return null;
    }
}
