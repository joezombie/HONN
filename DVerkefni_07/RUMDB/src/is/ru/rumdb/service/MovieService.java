package is.ru.rumdb.service;

import is.ru.rumdb.data.MovieDataGateway;
import is.ru.rumdb.domain.Movie;

import java.util.List;

public class MovieService extends ApplicationService
{
    private MovieDataGateway movieDataGateway;

    public void addMovie(Movie movie)
    {
        movie.initialize();
        movieDataGateway.addMovie(movie);
        getMailGateway().sendMessage(
                "somebody@something.doh",
                "me@ofcourse.duh",
                "Movie added",
                "The movie " + movie.getTitle() + " has been added"
                );
    }

    public List<Movie> getMovies()
    {
        return movieDataGateway.getMovies();
    }

    public void setMovieDataGateway(MovieDataGateway movieDataGateway)
    {
        this.movieDataGateway = movieDataGateway;
    }
}