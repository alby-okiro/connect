package src.core;

import java.util.Random;

/**
 * The Connect4ComputerPlayer class generates moves for the AI opponent in the Connect 4 game.
 * The computer makes a move in a random, valid column.
 */
public class Connect4ComputerPlayer {
    private final Random random;

    /**
     * Constructor initializes the random number generator.
     */
    public Connect4ComputerPlayer() {
        random = new Random();
    }

    /**
     * Generates a valid move for the computer but does NOT make the move.
     * @param logic The game logic instance to check available moves.
     * @return The column (0-based index) where the computer chooses to drop a piece.
     */
    public int generateMove(Connect4Logic logic) {
        int column;
        do {
            column = random.nextInt(7); // Pick a random column (0-6)
        } while (!isValidMove(logic, column)); // Ensure the column is not full
        return column;
    }

    /**
     * Checks if a move is valid (column is not full).
     * @param logic The game logic instance.
     * @param column The column to check.
     * @return true if the move is valid, false otherwise.
     */
    private boolean isValidMove(Connect4Logic logic, int column) {
        // Check if the top row is empty (column is not full)
        return logic.isColumnAvailable(column);
    }
}
