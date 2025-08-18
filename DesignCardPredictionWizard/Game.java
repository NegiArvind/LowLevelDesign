import models.*;
import strategy.GameVariant;

import java.util.Comparator;
import java.util.List;

public class Game {
    private final List<Player> players;
    private final GameVariant gameVariant;
    private final GameContext gameContext;
    private final Deck deck;
    private int currentIdx = 0;

    public Game(List<Player> players, GameVariant gameVariant) {
        this.players = players;
        this.gameVariant = gameVariant;
        this.gameContext = new GameContext(players);
        this.deck = gameVariant.setupDeck();
    }

    public void playFullyWithLogs() {
        System.out.println("=== PredictionWizard ===");
        System.out.println("Players: " + players);
        System.out.println("Deck size: " + deck.size());

        while (deck.hasAtLeast(1)) {
            if(!deck.hasAtLeast(gameVariant.minCardsNeededForTurn())) {
                gameVariant.handleSingleCardLeft(deck, players.get(currentIdx), gameContext);
                break;
            }
            playTurnsWithLogs(players.get(currentIdx));
            currentIdx = (currentIdx + 1) % players.size();
        }

        System.out.println("\n=== Final Scores ===");
        players.forEach(
                p -> System.out.println(p.getName() + ": " + p.score())
        );
        Player winner = players.stream().max(Comparator.comparingInt(Player::score)).orElse(null);
        System.out.println("Winner: " + (winner != null ? winner.getName() : "N/A"));
    }

    private void playTurnsWithLogs(Player player) {
        if (!deck.hasAtLeast(gameVariant.minCardsNeededForTurn())) return;

        boolean keepGoing = true;
        while(keepGoing && deck.hasAtLeast(2)) {
            Card first = deck.drawTop();
            System.out.println("\n" + player.getName() + " draws: " + first);

            Prediction guess = player.getPredictionStrategy().predict(first, deck, player, gameContext);
            System.out.println(player.getName() + " predicts: " + guess);

            if (!deck.hasAtLeast(1)) {
                System.out.println("Deck ended mid-turn.");
                return;
            }

            Card next = deck.drawTop();
            System.out.println("Next card: " + next);

            int cmp = Integer.compare(next.getRank().getVal(), first.getRank().getVal());
            boolean correct =
                    (guess == Prediction.EQUAL && cmp == 0) ||
                            (guess == Prediction.HIGHER && cmp > 0) ||
                            (guess == Prediction.LOWER && cmp < 0);

            if(correct) {
                int gained = gameVariant.onCorrectPrediction(guess, first, next, deck, player, gameContext);
                player.addWonCards(gained);
                System.out.println("✅ Correct! " + player.getName() + " gains " + gained + " card(s). Total: " + player.score());
                keepGoing = gameVariant.winnerContinues();
            } else {
                int discarded = gameVariant.onWrongPrediction(guess, first, next, deck, player, gameContext);
                System.out.println("❌ Wrong. Discarded " + discarded + " card(s).");
                keepGoing = false; // pass turn
            }
        }

    }
}
