package atmStates.impl;

import atmStates.AtmState;
import models.Atm;
import models.Card;

public class HasCardState implements AtmState {
    public HasCardState() {
        System.out.println("Enter your pin number");
    }

    @Override
    public void authenticatePin(Atm atm, Card card, String pin) {
        boolean isCorrectPinEntered = card.isCorrectPinEntered(pin);
        if(isCorrectPinEntered) {
            System.out.println("You entered correct pin");
            atm.setCurrentAtmState(new SelectOperationState());
        } else {
            System.out.println("Wrong pin entered");
            exit(atm);
        }
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setCurrentAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
