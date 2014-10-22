package is.ru.rumdb.domain;

/**
 * Created by joezombie on 1.10.2014.
 */
public class Rating {
    private int views;      // Number of requests
    private int rates;      // Number of rates
    private int ratings;    // Combined values of ratings

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public void incrementView(){
        this.views += 1;
    }

    public void incrementRating(int rating){
        this.ratings += rating;
        this.rates += 1;
    }

    public double getAverageRating(){
        return (ratings/rates);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "views=" + views +
                ", rates=" + rates +
                ", ratings=" + ratings +
                '}';
    }
}
