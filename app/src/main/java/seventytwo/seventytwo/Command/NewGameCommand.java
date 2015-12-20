package seventytwo.seventytwo.Command;

import seventytwo.seventytwo.Component.Board;
import seventytwo.seventytwo.Component.Cell;
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
        _board = createNewBoard();
    }

    private Board createNewBoard() {
        Cell[][] newBoard = _board.newBoard();
        _board.setBoard(newBoard);
        return _board;
    }
}
