package de.ait.javalessons.homework09.controller;

import de.ait.javalessons.homework09.movie.Movie;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/movies")
public class RestApiMovieController {
    private List<Movie> movieArrayList = new ArrayList<>();

    public RestApiMovieController() {
        movieArrayList.addAll(
                List.of(
                        new Movie(1, "Морская звезда", "Драма", 1995),
                        new Movie(2, "Пятница близко", "Комедия", 2005),
                        new Movie(3, "Магадан", "Боевик", 1993),
                        new Movie(4, "Бу", "Ужастик", 2015)
                )
        );
    }

    @GetMapping
    Iterable<Movie> getMovies() {
        return movieArrayList;
    }

    @GetMapping("/{id}")
    Optional<Movie> getMovieById(@PathVariable int id) {
        for (Movie movie : movieArrayList) {
            if (movie.getId() == id) {
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    Movie postMovie(@RequestBody Movie movie){
        movieArrayList.add(movie);
        return movie;
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable int id){
        movieArrayList.removeIf(movie -> movie.getId() == id);
    }
}


