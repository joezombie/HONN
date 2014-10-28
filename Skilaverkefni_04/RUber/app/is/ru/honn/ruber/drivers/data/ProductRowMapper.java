package is.ru.honn.ruber.drivers.data;

import org.springframework.jdbc.core.RowMapper;

import is.ru.honn.ruber.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return new Product(
            rs.getInt(1),       // id
            rs.getString(2),    // description
            rs.getString(3),    // display name
            rs.getInt(4),       // capacity
            rs.getString(5)     // image
        );
    }
}
