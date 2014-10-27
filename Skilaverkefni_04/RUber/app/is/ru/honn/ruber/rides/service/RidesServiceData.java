package is.ru.honn.ruber.rides.service;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.rides.data.RidesDataGateway;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public class RidesServiceData implements RidesService {
    private RidesDataGateway ridesDataGateway;
    public RidesServiceData(RidesDataGateway ridesDataGateway){
        this.ridesDataGateway = ridesDataGateway;
    }

    @Override
    public void addTrip(int userId, Trip trip) {
        int id = ridesDataGateway.addTrip(trip);
    }

    @Override
    public List<Trip> getTrip(int userId) {
        return ridesDataGateway.getTripsByUserId(userId);
    }
}
