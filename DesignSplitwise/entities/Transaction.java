package entities;

public class Transaction {
    private final User from;
    private final User to;
    private final double amount;

    public Transaction(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return from.getName() + " should pay " + to.getName() + " Rs " + String.format("%.2f", amount);
    }
}
