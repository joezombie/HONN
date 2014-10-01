package is.ru.rumdb.test;

import is.ru.rumdb.data.MovieDataGatewayStub;
import is.ru.rumdb.domain.Movie;
import is.ru.rumdb.mail.MailServerStub;
import is.ru.rumdb.service.MovieService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

class TestSimple
{
    public TestSimple()
    {
        MovieService movieService = new MovieService();
        movieService.setMailGateway(new MailServerStub());
        movieService.setMovieDataGateway(new MovieDataGatewayStub());

        movieService.addMovie(new Movie(1, "Movie 1", "http1", "", new Date(), ""));
        movieService.addMovie(new Movie(1, "Movie 2", "http2", "", new Date(), ""));
        movieService.addMovie(new Movie(1, "Movie 3", "http3", "", new Date(), ""));
        movieService.addMovie(new Movie(1, "Movie 4", "http4", "", new Date(), ""));

        List<Movie> list = movieService.getMovies();
        for (Movie movie: list)
        {
            System.out.println(movie);
        }
    }
    public static void main(String[] args)
    {
        new TestSimple();
    }


}