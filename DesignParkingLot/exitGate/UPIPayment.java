package exitGate;

public class UPIPayment implements Payment {
    @Override
    public boolean doPayment(int amount) {
        return false;
    }
}
