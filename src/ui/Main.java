package src.ui;

import src.core.Connect4Logic;
import src.core.Connect4ComputerPlayer;

/**
 * The Main class serves as the entry point for the Connect 4 game.
 */
public class Main {

    /**
     * Default constructor for Main class.
     */
    public Main() {
        // Default constructor
    }

    /**
     * The main method to start the Connect 4 game.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--auto")) {
            runAutoMode();
        } else {
            // interactive mode
            new Connect4TextConsole().startGame();
        }
    }

    /**
     * Runs a preset sequence of moves or logic without waiting for user input.
     */
    private static void runAutoMode() {
        // Example: Simulate a short game of Connect4 with random moves
        Connect4Logic logic = new Connect4Logic();
        Connect4ComputerPlayer computer = new Connect4ComputerPlayer();

        System.out.println("Running Connect4 in auto mode...");

        // For demonstration, let's do a few random moves:
        for (int i = 0; i < 10; i++) {
            int column = computer.generateMove(logic);
            System.out.println("Auto-move column: " + (column + 1));
            logic.makeMove(column);

            if (logic.checkWin()) {
                logic.displayBoard();
                System.out.println("Player " + logic.getCurrentPlayer() + " won the game!");
                break;
            } else if (logic.isBoardFull()) {
                logic.displayBoard();
                System.out.println("It's a draw!");
                break;
            }
            logic.switchPlayer();
        }

        // Show final board state
        logic.displayBoard();
        System.out.println("Auto mode finished!");
    }
}
