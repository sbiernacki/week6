package pl.writech.week6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.writech.week6.aspect.SendEmail;
import pl.writech.week6.model.Movie;
import pl.writech.week6.service.MovieService;

import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieApi {

    private MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.getMovies();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @SendEmail
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movieService.isAddedMovie(movie)) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
