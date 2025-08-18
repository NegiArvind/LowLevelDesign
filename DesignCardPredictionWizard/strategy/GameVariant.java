package strategy;

import models.*;

public interface GameVariant {

    default Deck setupDeck() {
        return new Deck(false);
    }

    /** How many cards the engine must ensure to run a turn under this variant. */
    default int minCardsNeededForTurn() {
        return 2;
    }

    default int onCorrectPrediction(Prediction prediction, Card first, Card next, Deck deck, Player winner,
                                    GameContext context) {
        // Default rule: winner keeps BOTH revealed cards.
        return 2;
    }

    default int onWrongPrediction(Prediction prediction, Card first, Card next, Deck deck, Player winner,
                                  GameContext context) {
        // Default: discard both; no score.
        return 2;
    }

    /** If true, after a win the same player continues the streak from the NEW top card. */
    default boolean winnerContinues() {
        return true;
    }

    /** Optional: if only 1 card remains at start, define how to handle. Default: skip turn. */
    default void handleSingleCardLeft(Deck deck, Player current, GameContext ctx) {
        // no-op; engine will end when deck exhausted
    }
}
