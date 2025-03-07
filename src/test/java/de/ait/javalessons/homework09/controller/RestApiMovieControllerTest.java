package de.ait.javalessons.homework09.controller;

import de.ait.javalessons.homework09.movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestApiMovieControllerTest {
    private RestApiMovieController restApiMovieController;

    @BeforeEach
    void setUp(){
        restApiMovieController = new RestApiMovieController();
    }

    @Test
    void testGetMoviesReturnDefaultMovies() {
        Iterable<Movie> resultMoviesIterable = restApiMovieController.getMovies();
        List<Movie> resultMovies = new ArrayList<>();
        resultMoviesIterable.forEach(resultMovies::add);

        assertEquals(4, resultMovies.size());
        assertEquals("Морская звезда", resultMovies.get(0).getTitle());
    }

    @Test
    void testGetMovieByIdWasFound(){
        Optional<Movie> result = restApiMovieController.getMovieById(2);
        assertTrue(result.isPresent());
        assertEquals("Пятница близко", result.get().getTitle());
    }

    @Test
    void testGetMovieByIdWasNotFound(){
        Optional<Movie> result = restApiMovieController.getMovieById(22);
        assertFalse(result.isPresent());
    }


    @Test
    void testPostMoviesAddNewMovie(){
        Movie movieToAdd = new Movie(5, "Зеленый круг", "Фантастика", 2009);
        Movie result = restApiMovieController.postMovie(movieToAdd);
        assertEquals("Зеленый круг", result.getTitle());
        assertEquals("Фантастика", result.getGenre());
        assertEquals(5, result.getId());
        assertEquals(2009, result.getYear());

        Iterable<Movie> resultMoviesIterable = restApiMovieController.getMovies();
        List<Movie> resultMovies = new ArrayList<>();
        resultMoviesIterable.forEach(resultMovies::add);
        assertEquals(5, resultMovies.size());
    }

    @Test
    void testDeleteMovie(){
        Iterable<Movie> resultMoviesIterable = restApiMovieController.getMovies();
        List<Movie> resultMovies = new ArrayList<>();
        resultMoviesIterable.forEach(resultMovies::add);
        assertEquals(4, resultMovies.size());
        restApiMovieController.deleteMovie(2);

        Iterable<Movie> resultMoviesIterableDeletedMovie = restApiMovieController.getMovies();
        resultMovies = new ArrayList<>();
        resultMoviesIterableDeletedMovie.forEach(resultMovies::add);
        assertEquals(3, resultMovies.size());
    }



}
