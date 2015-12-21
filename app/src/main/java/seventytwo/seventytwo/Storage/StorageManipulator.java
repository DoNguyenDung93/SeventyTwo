package seventytwo.seventytwo.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;

/**
 * Created by dongu on 15/12/2015.
 * This class handles the temporary storage which
 */
public class StorageManipulator {

    private ArrayList<String> _saveContent;
    private StorageHandler _storageHandler;
    private static Logger _logger = GlobalLogger.getInstance().getLogger();

    // Constructor
    public StorageManipulator() {
        _storageHandler = new StorageHandler();
    }

    // Accessors
    public ArrayList<String> getSaveContent() {
        return _saveContent;
    }


    public void generateStorageManipulator() throws IOException {
        _saveContent = _storageHandler.openSaveFile();
        _logger.log(Level.INFO, "Generate the temporary storage with the save content.");
    }

    // Mutator
    public void setSaveContent(ArrayList<String> saveContent) throws IOException {
        for (int i = 0; i < _saveContent.size(); i++) {
            _saveContent.set(i, saveContent.get(i));
        }
        _storageHandler.transferTempStorageToFile(saveContent);
        _logger.log(Level.INFO, "Overwrite the save content in the temp storage.");
    }


}
