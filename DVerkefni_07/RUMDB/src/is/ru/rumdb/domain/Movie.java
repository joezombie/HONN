package is.ru.rumdb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by joezombie on 1.10.2014.
 */
public class Movie implements Comparable<Movie>{
    private int id;
    private String title;
    private String link;
    private String description;
    private Date release;
    private String director;
    private Rating rating = new Rating();
    private List<Validator> validators = new ArrayList<Validator>();

    public Movie(int id, String title, String link, String description, Date release, String director) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.release = release;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Rating getRating() {
        return rating;
    }

    public void initialize(){
        //TODO
    }

    public void view(){
        this.rating.incrementView();
    }

    public void rate(int rating){
        this.rating.incrementRating(rating);
    }

    public double getAverageRate(){
        return rating.getAverageRating();
    }

    public boolean validate(){
        //TODO
        return false;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", release=" + release +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Movie other){
        return Integer.compare(this.id, other.id);
    }
}
