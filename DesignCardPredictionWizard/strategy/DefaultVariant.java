package strategy;

import models.Deck;

public class DefaultVariant implements GameVariant {

    private final boolean removeSevens;

    DefaultVariant(boolean removeSevens) {
        this.removeSevens = removeSevens;
    }

    @Override
    public Deck setupDeck() {
        return new Deck(removeSevens);
    }
}
