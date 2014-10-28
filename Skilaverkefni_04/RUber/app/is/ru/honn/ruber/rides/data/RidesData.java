package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.rides.service.TripExistsException;
import is.ru.honn.ruber.rides.service.TripNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public class RidesData extends RuData implements RidesDataGateway {
    @Override
    public int addTrip(Trip trip) {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_trips")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("riderId", trip.getRiderId());
        parameters.put("driverId", trip.getDriverId());
        parameters.put("requestTime", trip.getRequestTime());
        parameters.put("productId", trip.getProductId());
        parameters.put("tripStatus", trip.getStatus());
        parameters.put("distance", trip.getDistance());
        parameters.put("startTime", trip.getStartTime());
        parameters.put("endTime", trip.getEndTime());

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new TripExistsException("Trip " + Integer.toString(trip.getId()) + " already exits", divex);
        }

        trip.setId(returnKey);
        return returnKey;
    }

    @Override
    public Trip getTripById(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        Trip trip;
        try
        {
            trip = (Trip)jdbcTemplate.queryForObject(
                    "select * from ru_trips where id = '" + id.toString() + "'", new TripRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new TripNotFoundException("No trip found with id: " + id.toString());
        }
        return trip;
    }

    @Override
    public List<Trip> getTripsByUserId(Integer userId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Trip> trips;
        try
        {
            trips = jdbcTemplate.query("select * from ru_trips where riderId = '" + userId.toString() + "'", new BeanPropertyRowMapper<Trip>(Trip.class));
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new TripNotFoundException("No trips found for user: " + userId.toString());
        }
        return trips;
    }
}
