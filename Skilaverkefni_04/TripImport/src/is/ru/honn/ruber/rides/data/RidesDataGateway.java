package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.Trip;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public interface RidesDataGateway extends RuDataAccess {
    public int addTrip(Trip trip);
    public Trip getTripById(Integer id);
    public List<Trip> getTripsByUserId(Integer userId);
}
