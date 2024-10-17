package controllers;

import enums.City;
import models.Show;
import models.Theatre;
import models.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    private Map<City, List<Theatre>> cityTheatreMap;

    private List<Theatre> theatreList;

    public TheatreController() {
        cityTheatreMap = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    public void addTheatre(City city, Theatre theatre) {
        List<Theatre> existingTheatres = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        existingTheatres.add(theatre);
        theatreList.add(theatre);
        cityTheatreMap.put(city, existingTheatres);
    }

    void removeTheatre(City city, Theatre theatre) {
        // remove theatre from city
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        // get all theatres of this city
        Map<Theatre, List<Show>> theatreShowsMap = new HashMap<>();
        List<Theatre> theatres = cityTheatreMap.get(city);

        // Filter theatre which runs this movie
        for(Theatre theatre: theatres) {
            List<Show> shows = theatre.getShowList();
            List<Show> givenMovieShow = new ArrayList<>();
            shows.stream().forEach(show -> {
                if(show.getMovie().getId() == movie.getId()) {
                    givenMovieShow.add(show);
                }
            });
            if(!givenMovieShow.isEmpty()) {
                theatreShowsMap.put(theatre, givenMovieShow);
            }
        }
        return theatreShowsMap;
    }
}
