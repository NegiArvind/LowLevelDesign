public class Bill {
    Reservation reservation;
    boolean isBillPaid;
    double totalBillAmount;

    Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        isBillPaid = false;
    }

    private double computeBillAmount(){
        return 100.0;
    }

}
