package de.ait.javalessons.homework09.controller;

import de.ait.javalessons.homework09.movie.Movie;
import de.ait.javalessons.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiMovieControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private static final String BASE_URL = "/movies";


    @Test
    void testGetMoviesReturnDefaultMovies() {
        ResponseEntity<Movie[]> response = testRestTemplate.getForEntity(BASE_URL, Movie[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(4, response.getBody().length);
        assertEquals("Морская звезда", response.getBody()[0].getTitle());
        assertEquals("Драма", response.getBody()[0].getGenre());
        assertEquals(1, response.getBody()[0].getId());
        assertEquals(1995, response.getBody()[0].getYear());
    }

    @Test
    void testGetMoviesByIdWasFound() {
        ResponseEntity<Movie> response = testRestTemplate.getForEntity(BASE_URL + "/1", Movie.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Морская звезда", response.getBody().getTitle());
        assertEquals(1, response.getBody().getId());
        assertEquals(1995, response.getBody().getYear());
        assertEquals("Драма", response.getBody().getGenre());
    }

    @Test
    void testGetMoviesByIdWasNotFound() {
        ResponseEntity<Movie> response = testRestTemplate.getForEntity(BASE_URL + "/11", Movie.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testPostMoviesAddMovie() {
        Movie movieToAdd = new Movie(5, "Солнечный день", "Драма", 2023);
        ResponseEntity<Movie> response = testRestTemplate.postForEntity(BASE_URL, movieToAdd, Movie.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Солнечный день", response.getBody().getTitle());
        assertEquals("Драма", response.getBody().getGenre());
        assertEquals(5, response.getBody().getId());
        assertEquals(2023, response.getBody().getYear());

    }

}
