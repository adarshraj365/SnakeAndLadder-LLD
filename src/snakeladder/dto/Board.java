package snakeladder.dto;

public class Board {
    private BoardCell[] boardCells;
    private int TOTAL_CELL = 100;
    public Board() {
        this.boardCells = new BoardCell[TOTAL_CELL + 1];
        for(int i = 0 ; i <= TOTAL_CELL; i++) {
            this.boardCells[i] =  new BoardCell(i);
        }
    }

    public BoardCell getBoardCell(int index) {
        return this.boardCells[index];
    }
}
