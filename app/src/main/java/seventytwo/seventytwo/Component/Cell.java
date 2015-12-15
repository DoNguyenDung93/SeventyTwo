package seventytwo.seventytwo.Component;

import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;

/**
 * Created by dongu on 10/12/2015.
 * This class handles cell, which is an individual unit on the game board.
 */
public class Cell {
    // Attributes
    private int _xCoord;
    private int _yCoord;
    private Token _token = null;

    private static Logger _logger = GlobalLogger.getInstance().getLogger();

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

    public void setToken(Token token) {
        _token = token;
    }

    // Accessors
    public int getXCoord() {
        return _xCoord;
    }

    public int getYCoord() {
        return _yCoord;
    }

    public Token getToken() {
        return _token;
    }

    @Override
    public String toString() {
        String cellDetails = "";
        cellDetails = cellDetails.concat(Integer.toString(_xCoord)).concat(", ").concat(Integer.toString(_yCoord)).concat("\n");
        return cellDetails;
    }

    public boolean isCellEmpty() {
        boolean result = true;
        if (_token == null) {
            result = false;
        }
        return result;
    }
}
