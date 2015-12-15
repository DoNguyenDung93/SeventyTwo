package seventytwo.seventytwo.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;

/**
 * Created by dongu on 10/12/2015.
 * This class will handle the creation and manipulation of the game board, which consists of 72 cells.
 * Each cell will fit one token.
 */
public class Board {

    private static final int NO_OF_ROW = 10;
    private static final int NO_OF_COL = 11;

    private static Board _singleBoard = new Board();
    private static Logger _logger = GlobalLogger.getInstance().getLogger();

    // Attributes
    //private Cell[] row = new Cell[10];
    //private Cell[] column = new Cell[11];
    private Cell[][] board = new Cell[NO_OF_ROW][NO_OF_COL];

    // Constructor
    public Board() {
    }

    // Accessor
    public static Board getInstance() {
        if (_singleBoard == null) {
            _singleBoard = new Board();
        }
        _logger.log(Level.INFO, "Creating a new instance of the board.");
        return _singleBoard;
    }

    public Board newBoard() {
        // TODO
        _logger.log(Level.INFO, "Create a new board for new game.");
        return _singleBoard;
    }

    public Board saveBoard() {
        // TODO
        _logger.log(Level.INFO, "Save the current state of the board.");
        return _singleBoard;
    }

    public Board loadBoard() {
        // TODO
        _logger.log(Level.INFO, "Load a previous state of the board.");
        return _singleBoard;
    }

    private void clearBoard() {
        for (int i = 0; i < NO_OF_ROW; i++) {
            for (int j = 0; j < NO_OF_COL; j++) {
                board[i][j].setToken(null);
            }
        }
    }
}
