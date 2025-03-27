package snakeladder.processor;

import snakeladder.dto.Board;
import snakeladder.dto.Dice;
import snakeladder.dto.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SnakeLadderGameProcessor {

    public void play() throws FileNotFoundException {
        Board board = generateBoardWithGivenInputs();
        final Player player1 = new Player("Aman");
        final Player player2 = new Player("Adarsh");

        // This is allowed chances for the game (combined player1 + player2),
        // If no one win till this point we will consider tie.
        int ALLOWED_CHANCE = 200;
        for(int i = 0; i < ALLOWED_CHANCE; i++) {
            final int numberOnDice = Dice.rollDice();
            if(i % 2 == 0) {
                handlePlay(numberOnDice, player2, board);
            }
            else {
                handlePlay(numberOnDice, player1, board);
            }

            if(player1.getPosition() == 100) {
                player1.setWon();
                break;
            }
            if(player2.getPosition() == 100) {
                player2.setWon();
                break;
            }
        }

        if(player1.isWon()) {
            System.out.println("Player : " + player1.getName() + " Has won the game.");
        }
        else if(player2.isWon()) {
            System.out.println("Player : " + player2.getName() + " Has won the game.");
        }
        else {
            System.out.println("Game tie.");
        }

    }

    private void handlePlay(int diceRollNumber, Player player, Board board) {
        System.out.println("-----------------------");
        System.out.println("Player : " + player.getName() + " Turn.");
        System.out.println(String.format("Player : %s current postion on the board is : %s",
                player.getName(), player.getPosition()));
        System.out.println(String.format("Player : %s rolled the dice and get number %s on the dice",
                player.getName(), diceRollNumber));
        if(player.getPosition() + diceRollNumber > 100 ){
            System.out.println("Not a valid move");
            return;
        }
        player.setPosition(player.getPosition() + diceRollNumber);
        System.out.println(String.format("Player : %s new postion on the board is : %s",
                player.getName(), player.getPosition()));
        while(board.getBoardCell(player.getPosition()).isLadder()) {
            int currPosition = player.getPosition();
            player.setPosition(board.getBoardCell(player.getPosition()).getEndOfLadder());
            System.out.println(String.format("He move from %s to %s due to ladder at current cell.",
                    currPosition, player.getPosition()));
        }
        while(board.getBoardCell(player.getPosition()).isSnake()) {
            int currPosition = player.getPosition();
            player.setPosition(board.getBoardCell(player.getPosition()).getTailOfSnake());
            System.out.println(String.format("He move from %s to %s due to snake at current cell.",
                    currPosition, player.getPosition()));
        }
    }

    private Board generateBoardWithGivenInputs() throws FileNotFoundException {
        Board board = new Board();
        File ladder = new File("data/Ladder.txt");
        File snake = new File("data/Snake.txt");
        Scanner scanner = new Scanner(ladder);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            int ladderStart = Integer.parseInt(numbers[0]);
            int ladderEnd= Integer.parseInt(numbers[1]);
            board.getBoardCell(ladderStart).setCellAsLadder(ladderEnd);
        }
        scanner = new Scanner(snake);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            int snakeHead = Integer.parseInt(numbers[0]);
            int snakeTail= Integer.parseInt(numbers[1]);
            board.getBoardCell(snakeHead).setCellAsSnake(snakeTail);
        }
        return board;
    }
}
