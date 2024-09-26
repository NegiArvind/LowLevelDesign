package atmStates;

import models.Atm;
import models.Card;
import models.TransactionType;

public interface AtmState {

    public default void insertCard(Atm atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public default void authenticatePin(Atm atm, Card card, String pin) {
        System.out.println("OOPS!! Something went wrong");
    }

    public default void selectOperation(Atm atm, Card card, TransactionType type) {
        System.out.println("OOPS!! Something went wrong");

    }

    public default void cashWithdrawal(Atm atm, Card card, int withDrawAmount) {
        System.out.println("OOPS!! Something went wrong");
    }

    public default void displaceBalance(Atm atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public default void returnCard() {
        System.out.println("OOPS!! Something went wrong");
    }

    public default void exit(Atm atm) {
        System.out.println("OOPS!! Something went wrong");
    }
}
