package models;

import pieces.*;

public class Board {
    private final Cell[][] board;

    public Board() {
        board = new Cell[8][8];

        for(int row =0; row <8; row ++) {
            for(int col =0; col <8; col++) {
                board[row][col] = new Cell(row, col);
            }
        }

        setupPieces();
    }

    private void setupPieces() {
        // Add pawns and main pieces for both sides
        for (int j = 0; j < 8; j++) {
            board[1][j].setPiece(new Pawn(Color.WHITE));
            board[6][j].setPiece(new Pawn(Color.BLACK));
        }

        // Initialize white pieces
        board[0][0].setPiece(new Rook(Color.WHITE));
        board[0][1].setPiece(new Knight(Color.WHITE));
        board[0][2].setPiece(new Bishop(Color.WHITE));
        board[0][3].setPiece(new Queen(Color.WHITE));
        board[0][4].setPiece(new King(Color.WHITE));
        board[0][5].setPiece(new Bishop(Color.WHITE));
        board[0][6].setPiece(new Knight(Color.WHITE));
        board[0][7].setPiece(new Rook(Color.WHITE));

        // Initialize black pieces
        board[7][0].setPiece(new Rook(Color.BLACK));
        board[7][1].setPiece(new Knight(Color.BLACK));
        board[7][2].setPiece(new Bishop(Color.BLACK));
        board[7][3].setPiece(new Queen(Color.BLACK));
        board[7][4].setPiece(new King(Color.BLACK));
        board[7][5].setPiece(new Bishop(Color.BLACK));
        board[7][6].setPiece(new Knight(Color.BLACK));
        board[7][7].setPiece(new Rook(Color.BLACK));

    }

    public synchronized boolean movePiece(Move move) {
        Cell from = move.getStart();
        Cell to = move.getEnd();
        Piece fromPiece = from.getPiece();

        if(fromPiece == null || !fromPiece.canMove(this, from, to)) {
            return false;
        }

        to.setPiece(fromPiece);
        from.setPiece(null);
        return true;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public Piece getPiece(int row, int col) {
        return board[row][col].getPiece();
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col].setPiece(piece);
    }

    public boolean isCheckMate(Color color) {
        // Implement checkmate logic
        return false;
    }

    public boolean isStaleMate(Color color) {
        // Implement stalemate logic
        return false;
    }

}
