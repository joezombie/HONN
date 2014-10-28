package is.ru.honn.ruber.domain;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public class Driver {
    private int id;
    private int userId;

    public Driver(int userId) {
        this.userId = userId;
    }

    public Driver(int id, int userId) {
        this.id = id;
        this.userId = userId;
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
}
