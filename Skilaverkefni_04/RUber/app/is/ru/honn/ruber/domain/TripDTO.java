package is.ru.honn.ruber.domain;

import java.util.Date;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class TripDTO {
    private Date date;
    private double distance;
    private long time;
    private String driverName;
    private int driverId;

    public TripDTO(Date date, double distance, long time, String driverName, int driverId) {
        this.date = date;
        this.distance = distance;
        this.time = time;
        this.driverName = driverName;
        this.driverId = driverId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getTimeString(){
        return String.format("%02d:%02d",time / 60, time % 60);
    }
}
