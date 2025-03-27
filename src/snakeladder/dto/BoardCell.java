package snakeladder.dto;

public class BoardCell {
    private int index;
    private boolean isLadder;
    private int endOfLadder;
    private boolean isSnake;
    private int tailOfSnake;

    public BoardCell(final int index) {
        this.index = index;
        this.isLadder = false;
        this.isSnake = false;
    }

    public void setCellAsLadder(final int endOfLadder) {
        this.isLadder = true;
        this.endOfLadder = endOfLadder;
    }

    public void setCellAsSnake(final int tailOfSnake) {
        this.isSnake = true;
        this.tailOfSnake = tailOfSnake;
    }

    public boolean isSnake() {
        return this.isSnake;
    }

    public boolean isLadder() {
        return this.isLadder;
    }

    public int getEndOfLadder() {
        return this.endOfLadder;
    }

    public int getTailOfSnake() {
        return this.tailOfSnake;
    }
}
