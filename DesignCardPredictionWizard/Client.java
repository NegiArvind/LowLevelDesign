import models.Player;
import strategy.EqualBonusVariant;
import strategy.GameVariant;
import strategy.HeuristicStrategy;
import strategy.KeepOneUseSecondVariant;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameVariant gameVariant = new EqualBonusVariant(false);

        List<Player> players = Arrays.asList(
                new Player("Alice", new HeuristicStrategy()),
                new Player("Bob",   new HeuristicStrategy())
        );

        Game game = new Game(players, gameVariant);
        game.playFullyWithLogs();
    }
}
