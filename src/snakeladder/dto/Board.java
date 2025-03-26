package snakeladder.dto;

public class Board {
    private BoardCell[] board;

    public Board() {
        this.board = new BoardCell[100];
        for(int i = 0 ; i < 100; i++) {
            this.board[i] =  new BoardCell(i+1);
        }
    }
}
