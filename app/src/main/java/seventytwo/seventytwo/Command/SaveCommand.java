package seventytwo.seventytwo.Command;

import java.io.IOException;
import java.util.logging.Level;

import seventytwo.seventytwo.Component.Board;
import seventytwo.seventytwo.Logger.GlobalLogger;
import seventytwo.seventytwo.Storage.StorageManipulator;

/**
 * Created by dongu on 22/12/2015.
 * This class handles the saving of the board after each move.
 */
public class SaveCommand extends Command {

    // Constructor
    public SaveCommand() {
        if (getStorageManipulator() == null) {
            _storageManipulator = new StorageManipulator();
        }

        _logger = GlobalLogger.getInstance().getLogger();
        _board = new Board();
    }

    public String executeCommand() {
        try {
            _board = _board.saveBoard();
            _logger.log(Level.INFO, "Save the current board state into the save files.");
        } catch (IOException e) {
            _logger.log(Level.INFO, "Fail to save the current board state.");
        }
        return "Successfully save the current board state.";
    }
}
