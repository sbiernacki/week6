package pl.writech.week6.service;

import pl.writech.week6.model.Movie;

import java.util.List;

public interface MovieService {

    boolean isAddedMovie(Movie movie);
    List<Movie> getMovies();
}
