import models.Board;
import models.PieceType;
import models.Player;
import models.PlayingPieceO;
import models.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {

        // Creating two players
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player 1", crossPiece);

        PlayingPieceO noughtPiece = new PlayingPieceO();
        Player player2 = new Player("Player 2", noughtPiece);

        players.add(player1);
        players.add(player2);

        //initialize game board
        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {

            // take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            //get the free space from board
            gameBoard.printBoard();
            List<List<Integer>> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            //read the user input
            System.out.print("Player: " + playerTurn.getPlayingPiece().getPieceType() + " Please Enter row, column: ");
            Scanner inputScanner = new Scanner(System.in);
            String input = inputScanner.nextLine();
            String[] inputValues = input.split(",");
            int inputRow = Integer.parseInt(inputValues[0]);
            int inputColumn = Integer.parseInt(inputValues[1]);
            if(inputRow >= gameBoard.getSize() || inputRow < 0 || inputColumn >= gameBoard.getSize() || inputColumn < 0) {
                System.out.println("Incorrect position choosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            //place the piece
            boolean pieceAddSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.getPlayingPiece().getPieceType());
            if(!pieceAddSuccessfully) {
                System.out.println("Incorrect position choosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = doesItWin(inputRow, inputColumn, playerTurn.getPlayingPiece().getPieceType());
            if(winner) {
                return playerTurn.getName();
            }
        }
        return "Tie";
    }

    private boolean doesItWin(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // need to check in row
        for(int i=0; i< gameBoard.getSize(); i++) {
            if(gameBoard.getBoard()[row][i] == null || gameBoard.getBoard()[row][i] != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0; i< gameBoard.getSize(); i++) {
            if(gameBoard.getBoard()[i][column] == null || gameBoard.getBoard()[i][column] != pieceType) {
                columnMatch = false;
            }
        }

        // need to check diagonals
        for(int i=0, j=0; i< gameBoard.getSize(); i++, j++) {
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j] != pieceType) {
                diagonalMatch = false;
            }
        }


        // need to check anti diagonals
        for(int i=gameBoard.getSize()-1, j=0; j < gameBoard.getSize(); i--, j++) {
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j] != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
