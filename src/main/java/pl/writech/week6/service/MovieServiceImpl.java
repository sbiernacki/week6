package pl.writech.week6.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.writech.week6.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private List<Movie> movies;

    @EventListener(ApplicationReadyEvent.class)
    public void prepareMovies() {
        movies = new ArrayList<>();
        movies.add(new Movie("Spider-Man", 2002, "Sam Raimi"));
        movies.add(new Movie("Chłopaki nie płaczą", 2000, "Olaf Lubaszenko"));
        movies.add(new Movie("Killer", 1997, "Juliusz Machulski"));
    }

    public boolean isAddedMovie(Movie movie) {
        return movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
