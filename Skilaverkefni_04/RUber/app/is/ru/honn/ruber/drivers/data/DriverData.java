package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.drivers.service.DriverExistsException;
import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import org.springframework.jdbc.core.RowMapper;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway {
    private RowMapper<Driver> rowMapper;

    public DriverData(RowMapper<Driver> rowMapper){
        this.rowMapper = rowMapper;
    }

    @Override
    public int addDriver(Driver driver) {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_driver")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(1);
        parameters.put("userId", driver.getUser().getId());

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new DriverExistsException("User " + driver.getUser().getUsername() + " is already a driver", divex);
        }

        driver.setId(returnKey);
        return returnKey;
    }

    @Override
    public Driver getDriverById(Integer id) {
        Collection<String> drivers;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        Driver driver;
        try
        {
            driver = (Driver)jdbcTemplate.queryForObject(
                    "select * from ru_drivers where id = '" + id.toString() + "'", rowMapper);
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No driver found with id: " + id.toString());
        }
        return driver;
    }
}
