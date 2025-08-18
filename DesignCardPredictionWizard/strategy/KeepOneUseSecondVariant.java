package strategy;

import models.*;

public class KeepOneUseSecondVariant extends DefaultVariant {

    public KeepOneUseSecondVariant(boolean removeSevens) {
        super(removeSevens);
    }

    @Override
    public int onCorrectPrediction(Prediction prediction, Card first, Card next, Deck deck, Player winner, GameContext context) {
        return 1;
    }

    @Override
    public void handleSingleCardLeft(Deck deck, Player current, GameContext ctx) {
        // If exactly 1 card remains at start, nobody can predict.
        // Optionally, award it to current player to keep rules consistent.
        // We'll discard it here to keep fairness.
        deck.drawTop();
    }
}
