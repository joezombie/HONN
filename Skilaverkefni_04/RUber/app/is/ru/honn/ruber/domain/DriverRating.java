package is.ru.honn.ruber.domain;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class DriverRating {
    protected int id;
    protected int riderId;
    protected int driverId;
    protected int rating;
    protected String comment;

    public DriverRating() {

    }

    public DriverRating(int riderId, int driverId, int rating, String comment) {
        this.riderId = riderId;
        this.driverId = driverId;
        this.rating = rating;
        this.comment = comment;
    }

    public DriverRating(int id, int riderId, int driverId, int rating, String comment) {
        this.id = id;
        this.riderId = riderId;
        this.driverId = driverId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
