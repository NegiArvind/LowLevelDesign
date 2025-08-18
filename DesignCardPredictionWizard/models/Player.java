package models;

import strategy.PredictionStrategy;

public class Player {
    private final String name;
    private final PredictionStrategy predictionStrategy;
    private int cardsWon = 0;

    public Player(String name, PredictionStrategy predictionStrategy) {
        this.name = name;
        this.predictionStrategy = predictionStrategy;
    }

    public String getName() {
        return name;
    }

    public PredictionStrategy getPredictionStrategy() {
        return predictionStrategy;
    }

    public int score() {
        return cardsWon;
    }

    public void addWonCards(int n) {
        cardsWon += n;
    }

    @Override
    public String toString() {
        return name + " (" + cardsWon + ")";
    }
}
