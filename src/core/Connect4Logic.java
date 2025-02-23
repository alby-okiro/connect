package src.core;
/**
 * The Connect4Logic class contains the game logic for the Connect 4 game.
 * It manages the game board, validates moves, checks win/draw conditions,
 * and updates the game state.
 */
public class Connect4Logic {
    private final char[][] board;
    private char currentPlayer;

    /**
     * Constructor to initialize the Connect 4 game board and set the starting player.
     */
    
    public Connect4Logic() {
        board = new char[6][7];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    /**
     * Initializes the game board with empty spaces.
     */

    private void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    /**
     * Makes a move for the current player in the specified column.
     * @param column The column (0-based index) where the player wants to drop their piece.
     * @return true if the move is successful, false otherwise.
     */
    public boolean makeMove(int column) {
        try {
            if (column < 0 || column >= 7) {
                throw new IllegalArgumentException("Invalid column index: " + column + ". Column must be between 0 and 6.");
            }
            for (int row = 5; row >= 0; row--) {
                if (board[row][column] == ' ') {
                    board[row][column] = currentPlayer;
                    return true;
                }
            }
            throw new IllegalStateException("Column " + column + " is full.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while making a move: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Checks if the current player has won the game.
     * @return true if the current player has won, false otherwise.
     */

    public boolean checkWin() {
        // Check all directions: horizontal, vertical, diagonal (up-right and down-right)
        try {
            // Horizontal check
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col <= 3; col++) {
                    if (board[row][col] == currentPlayer &&
                            board[row][col + 1] == currentPlayer &&
                            board[row][col + 2] == currentPlayer &&
                            board[row][col + 3] == currentPlayer) {
                        return true;
                    }
                }
            }

            // Vertical check
            for (int col = 0; col < 7; col++) {
                for (int row = 0; row <= 2; row++) {
                    if (board[row][col] == currentPlayer &&
                            board[row + 1][col] == currentPlayer &&
                            board[row + 2][col] == currentPlayer &&
                            board[row + 3][col] == currentPlayer) {
                        return true;
                    }
                }
            }

            // Diagonal check downwards
            for (int row = 0; row <= 2; row++) {
                for (int col = 0; col <= 3; col++) {
                    if (board[row][col] == currentPlayer &&
                            board[row + 1][col + 1] == currentPlayer &&
                            board[row + 2][col + 2] == currentPlayer &&
                            board[row + 3][col + 3] == currentPlayer) {
                        return true;
                    }
                }
            }

            // Diagonal check upwards 
            for (int row = 3; row < 6; row++) {
                for (int col = 0; col <= 3; col++) {
                    if (board[row][col] == currentPlayer &&
                            board[row - 1][col + 1] == currentPlayer &&
                            board[row - 2][col + 2] == currentPlayer &&
                            board[row - 3][col + 3] == currentPlayer) {
                        return true;
                    }
                }
            }

            return false;
        } catch (Exception e) {
            System.out.println("An error occurred while checking for a win: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * changes the current player between 'X' and 'O'.
     */

    public void switchPlayer() {
        try {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } catch (Exception e) {
            System.out.println("Error switching player: " + e.getMessage());
        }
    }
    

    /**
     * Displays the current state of the board.
     */

    public void displayBoard() {
        try {
            for (char[] row : board) {
                for (char cell : row) {
                    System.out.print("| " + cell + " ");
                }
                System.out.println("|");
            }
            System.out.println("-----------------------------");
        } catch (Exception e) {
            System.out.println("Error displaying board: " + e.getMessage());
        }
    }

    /**
     * Gets the current player.
     * @return The character representing the current player ('X' or 'O').
     */
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Checks if the board is completely filled with no empty spaces.
     * @return true if the board is full, false otherwise.
     */
    public boolean isBoardFull() {
        try {
            for (int col = 0; col < 7; col++) {
                if (board[0][col] == ' ') { 
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error checking if board is full: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Checks if a column is available for a move.
     * @param column The column index.
     * @return true if there is space in the column, false otherwise.
     */

    public boolean isColumnAvailable(int column) {
        try {
            return board[0][column] == ' '; 
        } catch (Exception e) {
            System.out.println("Error checking column availability: " + e.getMessage());
            return false;
        }
    }
}
