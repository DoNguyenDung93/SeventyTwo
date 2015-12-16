package seventytwo.seventytwo.Command;

import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;
import seventytwo.seventytwo.Storage.StorageManipulator;

/**
 * Created by dongu on 15/12/2015.
 * This is an abstract class that is inherited by other command classes.
 */
public class Command {

    protected static StorageManipulator _storageManipulator;
    private static Logger _logger = GlobalLogger.getInstance().getLogger();

    public StorageManipulator getStorageManipulator() {
        return _storageManipulator;
    }


}
