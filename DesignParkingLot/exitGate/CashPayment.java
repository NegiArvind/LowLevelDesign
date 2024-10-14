package exitGate;

public class CashPayment implements Payment{
    @Override
    public boolean doPayment(int amount) {
        return false;
    }
}
