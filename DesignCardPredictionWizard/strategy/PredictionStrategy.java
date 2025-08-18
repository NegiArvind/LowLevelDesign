package strategy;

import models.*;

public interface PredictionStrategy {
    Prediction predict(Card visibleCard, Deck deck, Player me, GameContext gameContext);
}
