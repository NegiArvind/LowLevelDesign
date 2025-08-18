package strategy;

import models.*;

import java.util.Random;

public class HeuristicStrategy implements PredictionStrategy {

    private Random random = new Random();

    @Override
    public Prediction predict(Card visibleCard, Deck deck, Player me, GameContext gameContext) {
        int v = visibleCard.getRank().getVal();
        if(v <= 4) {
            return Prediction.HIGHER;
        }
        if(v >= 11) {
            return Prediction.LOWER;
        }

        // 10% try for equal
        int pick = random.nextInt(10);
        if(pick == 0) {
            return Prediction.EQUAL;
        }

        return random.nextBoolean() ? Prediction.HIGHER : Prediction.LOWER;
    }
}
