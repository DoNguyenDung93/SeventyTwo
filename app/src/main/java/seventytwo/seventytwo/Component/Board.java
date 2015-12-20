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

    private static final int NO_OF_ROW = 12;
    private static final int NO_OF_COL = 8;

    private static Logger _logger = GlobalLogger.getInstance().getLogger();
    private StorageManipulator _storageManipulator = new StorageManipulator();

    // Attributes
    private Cell[][] _board = new Cell[NO_OF_ROW][NO_OF_COL];

    // Constructor
    public Board() {
    }

    // Accessor
    public Cell[][] getBoard() {
        return _board;
    }

    // Mutator
    public void setBoard(Cell[][] board) {
        _board = board;
    }
    public Cell[][] newBoard() {
        clearBoard();

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.CYAN);
        colors.add(Color.GREEN);
        colors.add(Color.PINK);
        colors.add(Color.YELLOW);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        while (colors.size() != 0 && numbers.size() != 0) {
            Color randColor = Color.getRandomColor();
            int randNumber = new Random().nextInt(numbers.size());
            fillRandomCell(randColor, randNumber);
            colors.remove(getPositionInArrayList(colors, randColor));
            numbers.remove(getPositionInArrayList(numbers, randNumber));
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

    private void fillRandomCell(Color randColor, int randNumber) {
        int[] XYCoordinates = chooseRandomEmptyCell();
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

    private <T> int getPositionInArrayList(ArrayList<T> arrayList, T object) {
        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(object)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
