package seventytwo.seventytwo.Component;

/**
 * Created by dongu on 10/12/2015.
 * This class will handle the creation and manipulation of the game board, which consists of 72 cells.
 * Each cell will fit one token.
 */
public class Board {

    private static Board _singleBoard = new Board();

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
        return _singleBoard;
    }

    public Board saveBoard() {
        // TODO
        return _singleBoard;
    }

    public Board loadBoard() {
        // TODO
        return _singleBoard;
    }
}
