package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.users.service.UserService;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public class DriverRowMapper implements RowMapper<Driver>
{

    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return  new Driver(
                rs.getInt(1),       // id
                rs.getInt(2),       // user id
                rs.getInt(3),       // product id
                rs.getString(4)     // full name
        );
    }
}
