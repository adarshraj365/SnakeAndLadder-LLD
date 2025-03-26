package snakeladder.processor;

import snakeladder.dto.Board;
import snakeladder.dto.Dice;
import snakeladder.dto.Player;

public class SnakeLadderGameProcessor {

    public void play() {
        Board board = generateBoardWithGivenInputs();
        final Player player1 = new Player("Aman");
        final Player player2 = new Player("Adarsh");

        // This is allowed chances for the game (combined player1 + player2),
        // If no one win till this point we will consider tie.
        int ALLOWED_CHANCE = 200;
        for(int i = 0; i < ALLOWED_CHANCE; i++) {
            final int numberOnDice = Dice.rollDice();
            if(i%1 == 0) {
                // Player 2 chance

            }
            else {
                // Player 1 chance

            }
        }

    }

    private Board generateBoardWithGivenInputs() {
        // Read Ladder.txt and Snake.txt and generate the board.
        return new Board();
    }
}
