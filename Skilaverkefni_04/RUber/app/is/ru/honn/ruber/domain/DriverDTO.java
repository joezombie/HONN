package is.ru.honn.ruber.domain;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class DriverDTO {
    protected int id;
    protected int userId;
    protected Product product;
    protected String fullName;

    public DriverDTO(int id, int userId, Product product, String fullName) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
