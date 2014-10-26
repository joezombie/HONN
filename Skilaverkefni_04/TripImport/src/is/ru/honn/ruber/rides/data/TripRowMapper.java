package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public class TripRowMapper implements RowMapper<Trip> {
    @Override
    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Trip(
                rs.getInt(1), // Id
                rs.getInt(2), // rider Id
                rs.getInt(3), // driver Id
                rs.getLong(4), // request time
                rs.getInt(5), // product Id
                TripStatus.COMPLETED, // trip status
                rs.getDouble(7), // distance
                rs.getLong(8), // start time
                rs.getLong(9) // end time
        );
    }
}
