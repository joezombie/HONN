package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.drivers.data.DriverData;
import is.ruframework.data.RuData;

/**
 * Created by Johannes Gunnar Heidarsson on 27.10.2014.
 */
public class DriverServiceData extends RuData implements DriverService {
    private DriverData driverData;

    public DriverServiceData(DriverData driverData) {
        this.driverData = driverData;
    }
}
