package controllers;

import enums.City;
import models.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Controls all the crud operation on movie
 */
public class MovieController {
    private Map<City, List<Movie>> cityMovieMap;
    private List<Movie> allMovies;

    public MovieController() {
        cityMovieMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityMovieMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovieMap.put(city, movies);
    }

    public Movie getMovieByMovieName(String name) {
        return allMovies.stream().filter(movie -> movie.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityMovieMap.getOrDefault(city, new ArrayList<>());
    }

    public void removeMovie(int movieId, City city) {
        // remove movie from this city
    }


}
