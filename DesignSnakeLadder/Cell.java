public class Cell {
    private int cellNumber;
    private Jump jump;

    public Cell(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Cell(int cellNumber, Jump jump) {
        this.cellNumber = cellNumber;
        this.jump = jump;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
