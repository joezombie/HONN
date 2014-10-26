package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.UserService;
import is.ru.honn.ruber.users.service.UserServiceData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Johannes Gunnar Heidarsson on 26.10.2014.
 */
public class DriverRowMapper implements RowMapper<Driver>
{
    UserService userService = new UserServiceData(new UserData());

    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return  new Driver(
                rs.getInt(1),      // id
                userService.getUser(rs.getInt(2))   // user id
        );
    }
}
