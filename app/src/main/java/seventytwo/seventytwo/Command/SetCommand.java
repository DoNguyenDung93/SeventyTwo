package seventytwo.seventytwo.Command;

import seventytwo.seventytwo.Component.Board;
import seventytwo.seventytwo.Logger.GlobalLogger;
import seventytwo.seventytwo.Storage.StorageManipulator;

/**
 * Created by dongu on 20/12/2015.
 * This class handles the placement of a token on the board.
 */
public class SetCommand extends Command {

    // Constructor
    public SetCommand() {
        if (getStorageManipulator() == null) {
            _storageManipulator = new StorageManipulator();
        }

        _logger = GlobalLogger.getInstance().getLogger();
        _board = new Board();
    }

    public String executeCommand() {
        // TODO
        return "";
    }


}
