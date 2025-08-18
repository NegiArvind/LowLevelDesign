package strategy;

import models.*;

public class EqualBonusVariant extends DefaultVariant {

    public EqualBonusVariant(boolean removeSevens) {
        super(removeSevens);
    }

    /** Variant 1 (follow-up #1): EQUAL correct ⇒ keep 2 revealed + take 2 extra bonus cards. */
    @Override
    public int onCorrectPrediction(Prediction prediction, Card first, Card next, Deck deck, Player winner,
                                    GameContext context) {
        int gained = 2;
        if(prediction == Prediction.EQUAL) {
            // take up to 2 extra cards from top as bonus
            for(int i=0; i< 2; i++) {
                if(deck.hasAtLeast(1)) {
                    deck.drawTop(); // conceptually "take" the card into winner's pile
                    gained += 1;
                }
            }
        }
        return gained;
    }



}
