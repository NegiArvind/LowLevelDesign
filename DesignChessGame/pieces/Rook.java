package pieces;

import models.Board;
import models.Cell;
import models.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        boolean isRowOnly = from.getRow() == to.getRow();
        boolean isColOnly = from.getCol() == to.getCol();
        return isRowOnly || isColOnly;
    }
}
