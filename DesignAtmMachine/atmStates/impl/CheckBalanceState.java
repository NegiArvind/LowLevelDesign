package atmStates.impl;

import atmStates.AtmState;
import models.Atm;
import models.Card;

public class CheckBalanceState implements AtmState {
    @Override
    public void displaceBalance(Atm atm, Card card) {
        System.out.println("Your balance in the account is : " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(Atm atm) {
        atm.setCurrentAtmState(new IdleState());
        returnCard();
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
