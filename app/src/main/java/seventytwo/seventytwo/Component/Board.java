package seventytwo.seventytwo.Component;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;
import seventytwo.seventytwo.Storage.StorageManipulator;

/**
 * Created by dongu on 10/12/2015.
 * This class will handle the creation and manipulation of the game board, which consists of 72 cells.
 * Each cell will fit one token.
 */
public class Board {

    private static final int NO_OF_ROW = 8;
    private static final int NO_OF_COL = 9;
    private static final int NO_OF_STARTING_TOKENS = 6;
    private static final int NO_OF_NUMBERS = 6;

    private static Logger _logger = GlobalLogger.getInstance().getLogger();
    private StorageManipulator _storageManipulator = new StorageManipulator();

    // Attributes
    private Cell[][] _board = new Cell[NO_OF_ROW][NO_OF_COL];

    // Constructor
    public Board(Cell[][] board) {
        _board = board;
    }

    public Cell[][] newBoard() {
        //Cell[][] board = new Cell[NO_OF_ROW][NO_OF_COL];
        clearBoard();
        for (int a = 0; a < NO_OF_STARTING_TOKENS; a++) {
            fillRandomCell();
        }
        _logger.log(Level.INFO, "Create a new board for new game.");
        return _board;
    }

    public Cell[][] saveBoard() {
        ArrayList<String> saveContent = new ArrayList<>();
        for (int i = 0; i < NO_OF_COL; i++) {
            for (int j = 0; j < NO_OF_ROW; j++) {
                Token token = _board[i][j].getToken();
                saveContent.add(token.toString());
            }
        }
        _storageManipulator.setSaveContent(saveContent);
        _logger.log(Level.INFO, "Save the current state of the board.");
        return _board;
    }

    public Cell[][] loadBoard() {
        ArrayList<String> saveContent = _storageManipulator.getSaveContent();
        for (int i = 0; i < NO_OF_COL; i++) {
            for (int j = 0; j < NO_OF_ROW; j++) {
                fillBoard(saveContent);
            }
        }
        _logger.log(Level.INFO, "Load a previous state of the board.");
        return _board;
    }

    private void clearBoard() {
        for (int i = 0; i < NO_OF_ROW; i++) {
            for (int j = 0; j < NO_OF_COL; j++) {
                _board[i][j].setToken(null);
            }
        }
        _logger.log(Level.INFO, "Clear the board of the current tokens.");
    }

    private void fillBoard(ArrayList<String> saveContent) {
        String tokenDetails = saveContent.get(0);
        String[] tokenDetailsArray = tokenDetails.split(" ");
        for (int i = 0; i < NO_OF_COL; i++) {
            for (int j = 0; j < NO_OF_ROW; j++) {
                _board[i][j].setToken(Token.fromString(tokenDetailsArray[i+j]));
            }
        }
        _logger.log(Level.INFO, "Fill the board with saved data.");
    }

    private void fillRandomCell() {
        int[] XYCoordinates = chooseRandomEmptyCell();
        Color randColor = Color.getRandomColor();
        int randNumber = new Random().nextInt(NO_OF_NUMBERS);
        _board[XYCoordinates[0]][XYCoordinates[1]].setToken(new Token(randColor, randNumber));
    }

    private int[] chooseRandomEmptyCell() {
        int i = new Random().nextInt(NO_OF_ROW);
        int j = new Random().nextInt(NO_OF_COL);
        if (_board[i][j] != null) {
            return chooseRandomEmptyCell();
        } else {
            return new int[] {i, j};
        }
    }
}
