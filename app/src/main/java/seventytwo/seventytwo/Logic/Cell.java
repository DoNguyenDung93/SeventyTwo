package seventytwo.seventytwo.Logic;

/**
 * Created by dongu on 10/12/2015.
 * This class handles cell, which is an individual unit on the game board.
 */
public class Cell {
    // Attributes
    private int _xCoord;
    private int _yCoord;

    // Constructors
    public Cell(Cell cell) {
        _xCoord = cell.getXCoord();
        _yCoord = cell.getYCoord();
    }

    public Cell(int x, int y) {
        _xCoord = x;
        _yCoord = y;
    }

    // Mutators
    public void setXCoord(int x) {
        _xCoord = x;
    }

    public void setYCoord(int y) {
        _yCoord = y;
    }

    // Accessors
    public int getXCoord() {
        return _xCoord;
    }

    public int getYCoord() {
        return _yCoord;
    }

    @Override
    public String toString() {
        String cellDetails = "";
        cellDetails = cellDetails.concat(Integer.toString(_xCoord)).concat(", ").concat(Integer.toString(_yCoord)).concat("\n");
        return cellDetails;
    }
}
