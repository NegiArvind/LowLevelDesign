package atmStates.impl;

import atmStates.AtmState;
import atmStates.impl.HasCardState;
import models.Atm;
import models.Card;

public class IdleState implements AtmState {
    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentAtmState(new HasCardState());
    }
}
