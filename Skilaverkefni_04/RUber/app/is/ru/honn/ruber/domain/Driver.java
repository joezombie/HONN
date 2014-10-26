package is.ru.honn.ruber.domain;

/**
 * Created by Johannes Gunnar Heidarsson on 25.10.2014.
 */
public class Driver {
    private int id;
    private User user;

    public Driver(int id, User user){
        this.id = id;
        this.user = user;
    }

    public Driver(User user){
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public User getUser() {
        return user;
    }
}
