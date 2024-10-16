import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    private Deque<Player> players;
    private Player winner;

    Game() {
        players = new LinkedList<>();
        initializeGame();
    }

    void initializeGame() {
        board = new Board(10, 5, 5);
        dice = new Dice(1);
        addPlayers();
        winner = null;
    }


    void startGame() {

        while(winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.getName() + " current position is: " + playerTurn.getCurrentPosition());

            // roll dice
            int diceNumber = dice.rollDice();

            // get the new position
            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumber;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setCurrentPosition(playerNewPosition);

            System.out.println("Player turn is:" + playerTurn.getName() + " New Position is: " + playerNewPosition);

            if(playerNewPosition >= board.getCells().length * board.getCells().length) {
                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS: " + winner.getName());
    }

    Player findPlayerTurn() {
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    void addPlayers() {
        Player player1 = new Player("Player 1", 1);
        Player player2 = new Player("Player 2", 1);
        this.players.add(player1);
        this.players.add(player2);
    }

    private int jumpCheck(int playerPosition) {
        if(playerPosition > board.getCells().length * board.getCells().length) {
            return playerPosition;
        }

        Cell cell = board.getCell(playerPosition);
        if(cell.getJump() != null && cell.getJump().getStart() == playerPosition) {
            String jumpBy = (cell.getJump().getStart() < cell.getJump().getEnd())? "ladder" : "snake";
            System.out.println("Jump done by: " + jumpBy);
            playerPosition = cell.getJump().getEnd();
        }
        return  playerPosition;

    }
}
