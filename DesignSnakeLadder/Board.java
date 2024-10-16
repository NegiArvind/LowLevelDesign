import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        setupSnakeAndLadders(numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i=0; i < boardSize; i++) {
            for(int j =0; j < boardSize; j++) {
                int cellPosition;
                if(i%2 == 0) {
                    cellPosition = i* boardSize + j + 1;
                } else {
                    cellPosition = i* boardSize + (boardSize -j);
                }
                Cell cell = new Cell(cellPosition);
                cells[i][j] = cell;
            }
        }
    }

    private void setupSnakeAndLadders(int numberOfSnakes, int numberOfLadders) {
        while(numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length + 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length + 1);
            if(snakeTail >= snakeHead) {
                continue;
            }

            Jump snakeObj = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setJump(snakeObj);

            numberOfSnakes--;
        }

        while(numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length + 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length + 1);
            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladderObj = new Jump(ladderStart, ladderEnd);
            Cell cell = getCell(ladderStart);
            cell.setJump(ladderObj);

            numberOfLadders--;
        }
    }

    public Cell getCell(int playerPosition) {
        for(int i=0; i< cells.length; i++) {
            for(int j=0; j< cells.length; j++) {
                if(cells[i][j].getCellNumber() == playerPosition) {
                    return cells[i][j];
                }
            }
        }
        return null;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
