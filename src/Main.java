import snakeladder.processor.SnakeLadderGameProcessor;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SnakeLadderGameProcessor game = new SnakeLadderGameProcessor();
        game.play();
    }
}