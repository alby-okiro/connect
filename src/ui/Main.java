package src.ui;

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
        new Connect4TextConsole().startGame();
    }
}
