package is.ru.rumdb.data;

import is.ru.rumdb.domain.Movie;

import java.util.List;

/**
 * Created by joezombie on 1.10.2014.
 */
public interface MovieDataGateway {
    public void addMovie(Movie movie);
    public List<Movie> getMovies();
}
