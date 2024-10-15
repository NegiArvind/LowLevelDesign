import java.util.List;

public class ReservationManagement {

    private List<Reservation> reservationList;

    Reservation createReservation(Vehicle vehicle, User user) {
        return new Reservation(vehicle, user, ReservationType.DAILY, ReservationStatus.SCHEDULED,1);
    }

    public void completeReservation(int reservationId) {

    }
}
