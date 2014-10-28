package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverRating;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.drivers.service.DriverExistsException;
import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.RatingExistsException;
import is.ru.honn.ruber.users.service.UsernameExistsException;
import org.springframework.jdbc.core.RowMapper;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway {
    private RowMapper<Driver> driverRowMapper = new DriverRowMapper();
    private RowMapper<Product> productRowMapper = new ProductRowMapper();

    @Override
    public int addDriver(Driver driver) {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_driver")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(1);
        parameters.put("userId", driver.getUserId());

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new DriverExistsException("User " + driver.getUserId() + " is already a driver", divex);
        }

        driver.setId(returnKey);
        return returnKey;
    }

    @Override
    public Driver getDriverById(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        Driver driver;
        try
        {
            driver = (Driver)jdbcTemplate.queryForObject(
                    "select * from ru_drivers where id = '" + id.toString() + "'", driverRowMapper);
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No driver found with id: " + id.toString());
        }
        return driver;
    }

    @Override
    public List<Driver> getAllDrivers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Driver> drivers;
        try
        {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from ru_drivers");

            drivers = new ArrayList<Driver>();
            for(Map row: rows){
                drivers.add(new Driver((int) row.get("id"), (int) row.get("userId"), (int) row.get("productId"), (String) row.get("fullName")));
            }

        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No drivers found");
        }
        return drivers;
    }

    @Override
    public Product getProduct(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        Product product;
        try
        {
            product = (Product)jdbcTemplate.queryForObject(
                    "select * from ru_products where id = '" + id.toString() + "'", productRowMapper);
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No driver found with id: " + id.toString());
        }
        return product;
    }

    @Override
    public List<DriverRating> getRatingForDriver(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<DriverRating> ratings;
        try
        {
            String sql = "select * from ru_driver_ratings where driverId ='" + id.toString() + "'";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            ratings = new ArrayList<DriverRating>();
            for(Map row: rows){
                ratings.add(new DriverRating(
                        (int)row.get("id"),
                        (int) row.get("riderId"),
                        (int) row.get("driverId"),
                        (int) row.get("rating"),
                        (String) row.get("comment")
                ));
            }

        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new DriverNotFoundException("No drivers found");
        }
        return ratings;
    }



    @Override
    public DriverRating addRatingForDriver(DriverRating rating) {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_driver_ratings")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(4);
        parameters.put("riderId", rating.getRiderId());
        parameters.put("driverId", rating.getDriverId());
        parameters.put("rating", rating.getRating());
        parameters.put("comment", rating.getComment());

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new RatingExistsException("There was a problem inserting the rating");
        }

        rating.setId(returnKey);
        return rating;

    }
}
