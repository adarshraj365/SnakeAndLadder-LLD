package snakeladder.dto;

public class BoardCell {
    private int index;
    private boolean isLadder;
    private int endOfLadder;
    private boolean isSnake;
    private int tailOfSnake;

    public BoardCell(final int index) {
        this.index = index;
    }

    public void setCellAsLadder(final int endOfLadder) {
        this.isLadder = true;
        this.endOfLadder = endOfLadder;
    }

    public void setCellAsSnake(final int tailOfSnake) {
        this.isSnake = true;
        this.tailOfSnake = tailOfSnake;
    }
}
