package seventytwo.seventytwo.Command;

import java.util.logging.Level;

import seventytwo.seventytwo.Component.Board;
import seventytwo.seventytwo.Logger.GlobalLogger;
import seventytwo.seventytwo.Storage.StorageManipulator;


/**
 * Created by dongu on 11/12/2015.
 * This class handles the generation of a new board when the user choose to start a new game.
 */
public class NewGameCommand extends Command{

    // Constructor
    public NewGameCommand() {
        if (getStorageManipulator() == null) {
            _storageManipulator = new StorageManipulator();
        }

        _logger = GlobalLogger.getInstance().getLogger();
        _board = new Board();
    }

    public String executeCommand() {
        _board = _board.createNewBoard();
        _logger.log(Level.INFO, "Execute the command of ");
        return "Successfully create new game.";
    }

}
