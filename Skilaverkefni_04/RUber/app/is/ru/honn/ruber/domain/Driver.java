package is.ru.honn.ruber.domain;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public class Driver {
    protected int id;
    protected int userId;
    protected int productId;
    protected String fullName;

    public Driver(int userId) {
        this.userId = userId;
    }

    public Driver(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Driver(int id, int userId, int productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    public Driver(int id, int userId, int productId, String fullName) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
