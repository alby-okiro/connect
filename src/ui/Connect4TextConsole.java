package src.ui;

import src.core.Connect4Logic;
import src.core.Connect4ComputerPlayer;
import java.util.Scanner;

/**
* The Connect4TextConsole class provides a console-based user interface for the Connect 4 game.
* It handles player interactions and game logic.
*/
public class Connect4TextConsole {
    private Connect4Logic logic;
    private Connect4ComputerPlayer computer;
    private Scanner scanner;
    private boolean isAgainstComputer;


    /**
     * Constructor to initialize the Connect 4 game logic and scanner.
     */
    public Connect4TextConsole() {
        logic = new Connect4Logic();
        computer = new Connect4ComputerPlayer();
        scanner = new Scanner(System.in);
    }
    
    /**
     * Starts the Connect 4 game.
     * When its called here is where it call and compile this code 
     */

    public void startGame() {

        // Ask if the player wants to play against a human or the computer
        System.out.println("Begin Game. Enter 'P' to play against another player, or 'C' to play against the computer:");

        try {
            String choice = scanner.nextLine().trim().toUpperCase();
            isAgainstComputer = choice.equals("C");
            if (isAgainstComputer) {
                System.out.println("Start game against computer.");  //prints the player is playing against a computer
            }
        } catch (Exception e) { // sends an exception if an error occurs.
            System.out.println("Error with player choice: " + e.getMessage());
        }

        boolean replay = true;

        while (replay) {
            logic = new Connect4Logic(); // Reset the game
            boolean gameWon = false;

            while (!gameWon) {
                logic.displayBoard();
                int column;

                if (isAgainstComputer && logic.getCurrentPlayer() == 'O') {
                    // Computer Player's Turn
                    column = computer.generateMove(logic);
                    System.out.println("Computer chooses column " + (column + 1));
                } else {
                    // Human Player's Turn
                    System.out.println("Player " + logic.getCurrentPlayer() + ", choose a column (1-7):");

                    try {
                        column = Integer.parseInt(scanner.nextLine()) - 1;
                        if (column < 0 || column >= 7) {// throws an error if the value entered is not between 1-7
                            throw new IllegalArgumentException("Column must be between 1 and 7.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a number between 1 and 7.");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } catch (Exception e) {
                        System.out.println("Unexpected error while processing move: " + e.getMessage());
                        continue;
                    }
                }

                if (logic.makeMove(column)) {
                    if (logic.checkWin()) {
                        logic.displayBoard();
                        System.out.println("Player " + logic.getCurrentPlayer() + " won the game!");
                        gameWon = true;
                    } else if (logic.isBoardFull()) {
                        logic.displayBoard();
                        System.out.println("It's a Draw!");
                        gameWon = true;
                    } else {
                        logic.switchPlayer(); // Switch to the next player
                    }
                } else {
                    System.out.println("Column full! Try another column.");
                }
            }

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (yes/no):");
            try {
                replay = scanner.nextLine().trim().equalsIgnoreCase("yes");
            } catch (Exception e) {
                System.out.println("Error reading replay choice: " + e.getMessage());
            }
        }

        System.out.println("Thanks for playing Connect 4!");
        scanner.close();
    }
}
