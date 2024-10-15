import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Reservation {

    int id;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    LocalDateTime bookingDateFrom;
    LocalDateTime bookingDateTo;
    Location pickupLocation;
    Location dropLocation;
    Location reservationLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;

    Reservation(Vehicle vehicle, User user, ReservationType reservationType, ReservationStatus reservationStatus, int id) {
        this.id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.reservationStatus = reservationStatus;
        this.reservationType = reservationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getBookingDateFrom() {
        return bookingDateFrom;
    }

    public void setBookingDateFrom(LocalDateTime bookingDateFrom) {
        this.bookingDateFrom = bookingDateFrom;
    }

    public LocalDateTime getBookingDateTo() {
        return bookingDateTo;
    }

    public void setBookingDateTo(LocalDateTime bookingDateTo) {
        this.bookingDateTo = bookingDateTo;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Location getReservationLocation() {
        return reservationLocation;
    }

    public void setReservationLocation(Location reservationLocation) {
        this.reservationLocation = reservationLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
