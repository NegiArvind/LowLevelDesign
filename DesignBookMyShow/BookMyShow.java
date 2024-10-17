import controllers.MovieController;
import controllers.TheatreController;
import enums.SeatCategory;
import models.Address;
import models.Seat;
import models.Theatre;
import models.Movie;
import models.Screen;
import models.Show;
import models.Booking;
import enums.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
        //user2
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");

    }

    private void initialize() {
        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();

    }

    private void createBooking(City userCityName, String movieName) {
        // 1 search movie by location
        List<Movie> movieList = movieController.getMoviesByCity(userCityName);

        // 2 select the movie which you want to see
        Movie interestedMovie = movieList.stream().filter(movie -> movie.getName().equalsIgnoreCase(movieName)).findFirst().orElse(null);

        // 3 get all show of this movie in city
        Map<Theatre, List<Show>> theatreShowMap = theatreController.getAllShow(interestedMovie, userCityName);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = theatreShowMap.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        // 5 select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();

        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);

            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            interestedShow.getScreen().getSeatList().stream().forEach(seat -> {
                        if (seat.getSeatId() == seatNumber) {
                            myBookedSeats.add(seat);
                        }
                    }
            );
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }



    //creating 2 theatre
    private void createTheatre() {

        Movie avengerMovie = movieController.getMovieByMovieName("AVENGERS");
        Movie baahubali = movieController.getMovieByMovieName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setId(1);
        inoxTheatre.setScreenList(createScreen());
        inoxTheatre.setAddress(new Address(City.BANGALORE, "Hyderabad", "India"));

        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreenList().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreenList().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShowList(inoxShows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setId(2);
        pvrTheatre.setScreenList(createScreen());
        pvrTheatre.setAddress(new Address(City.DELHI, "Delhi", "India"));

        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreenList().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreenList().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShowList(pvrShows);

        theatreController.addTheatre(City.BANGALORE, inoxTheatre);
        theatreController.addTheatre(City.DELHI, pvrTheatre);
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setId(1);
        screen1.setSeatList(createSeats());
        screens.add(screen1);
        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        show.setBookedSeatIds(new ArrayList<>());
        return show;
    }


    private List<Seat> createSeats() {
        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : GOLD
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //70 to 100 : PLATINUM
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;

    }


    private void createMovies() {

        //create Movies1
        Movie avengers = new Movie();
        avengers.setId(1);
        avengers.setName("AVENGERS");
        avengers.setDuration(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setId(2);
        baahubali.setName("BAAHUBALI");
        baahubali.setDuration(180);


        //add movies against the cities
        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(avengers, City.DELHI);
        movieController.addMovie(baahubali, City.BANGALORE);
        movieController.addMovie(baahubali, City.DELHI);
    }


}
