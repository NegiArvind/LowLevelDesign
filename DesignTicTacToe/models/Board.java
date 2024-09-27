package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private PieceType[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PieceType[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PieceType[][] getBoard() {
        return board;
    }

    public void setBoard(PieceType[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getFreeCells() {
        List<List<Integer>> freeCells = new ArrayList<>();
        for(int i=0; i< size; i++) {
            for (int j=0; j< size; j++) {
                if(board[i][j] == null) {
                    freeCells.add(List.of(i, j));
                }
            }
        }
        return freeCells;
    }


    public boolean addPiece(int inputRow, int inputColumn, PieceType pieceType) {
        if(board[inputRow][inputColumn] != null) {
            return false;
        }
        board[inputRow][inputColumn] = pieceType;
        return true;
    }
}
