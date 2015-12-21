package seventytwo.seventytwo.Command;

import seventytwo.seventytwo.Component.Board;
import seventytwo.seventytwo.Logger.GlobalLogger;
import seventytwo.seventytwo.Storage.StorageManipulator;

/**
 * Created by dongu on 11/12/2015.
 * This class handles the loading of the last board state when the user choose to continue the last game
 */
public class ContinueCommand extends Command {

    // Constructor
    public ContinueCommand() {
        if (getStorageManipulator() == null) {
            _storageManipulator = new StorageManipulator();
        }

        _logger = GlobalLogger.getInstance().getLogger();
        _board = new Board();
    }

//    public String executeCommand() {
//        _board.setBoard(_board.loadBoard());
//
//    }
}
