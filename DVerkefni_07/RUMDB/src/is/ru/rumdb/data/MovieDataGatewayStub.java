package is.ru.rumdb.data;

import is.ru.rumdb.domain.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joezombie on 1.10.2014.
 */
public class MovieDataGatewayStub implements MovieDataGateway {
    List<Movie> movies = new ArrayList<Movie>();

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }
}
