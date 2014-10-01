package is.ru.rumdb.domain;

/**
 * Created by joezombie on 1.10.2014.
 */
public class DefaultMovieValidator implements Validator{
    Movie movie;

    public DefaultMovieValidator(Movie movie){
        this.movie = movie;
    }

    @Override
    public boolean validate() {
        return !(movie.getTitle().isEmpty() || movie.getLink().isEmpty());
    }
}
