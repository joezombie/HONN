package is.ru.honn.ruber.domain;

/**
 * Created by Johannes Gunnar Heidarsson on 30.9.2014.
 */
public class Trip {
    protected String uuid;
    protected int requestTime;
    protected String productId;
    protected TripStatus status;
    protected float distance;
    protected int startTime;
    protected int endTime;

    public Trip(String uuid, int requestTime, String productId, TripStatus status, float distance, int startTime, int endTime) {
        this.uuid = uuid;
        this.requestTime = requestTime;
        this.productId = productId;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(int requestTime) {
        this.requestTime = requestTime;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
