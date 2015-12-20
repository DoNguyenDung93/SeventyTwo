package seventytwo.seventytwo.Command;

import java.util.logging.Logger;

import seventytwo.seventytwo.Component.Board;
import seventytwo.seventytwo.Storage.StorageManipulator;

/**
 * Created by dongu on 15/12/2015.
 * This is an abstract class that is inherited by other command classes.
 */
public class Command {

    protected static StorageManipulator _storageManipulator;
    protected static Logger _logger;
    protected Board _board;

    public StorageManipulator getStorageManipulator() {
        return _storageManipulator;
    }

    public Board getBoard() { return _board; }

}
