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

    private static Board _singleBoard = new Board();
    private static Logger _logger = GlobalLogger.getInstance().getLogger();

    // Attributes
    private Cell[] row = new Cell[10];
    private Cell[] column = new Cell[11];

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

    }
}
