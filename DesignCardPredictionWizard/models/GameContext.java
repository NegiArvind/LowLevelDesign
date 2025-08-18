package models;

import java.util.List;

public class GameContext {
    private final List<Player> players;

    public GameContext(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
