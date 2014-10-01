package is.ru.honn.ruber.domain;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 30.9.2014.
 */
public class History {
    protected int offset;
    protected int limit;
    protected int count;
    protected List<TripStatus> history;

    public History(int offset, int limit, int count, List<TripStatus> history) {
        this.offset = offset;
        this.limit = limit;
        this.count = count;
        this.history = history;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TripStatus> getHistory() {
        return history;
    }

    public void setHistory(List<TripStatus> history) {
        this.history = history;
    }

    public void addTripStatus(TripStatus status) {
        this.history.add(status);
    }
}
