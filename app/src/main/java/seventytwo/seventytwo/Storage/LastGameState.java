package seventytwo.seventytwo.Storage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import seventytwo.seventytwo.Component.Board;
import seventytwo.seventytwo.Logger.GlobalLogger;

/**
 * Created by dongu on 10/12/2015.
 * This class remembers the last game state so that the user will be able to continue the last game.
 */
public class LastGameState {

    // Attribute
    private File _saveFile;

    private static Logger _logger = GlobalLogger.getInstance().getLogger();
    // Constructor

    public LastGameState() {
    }

    public Board openSaveFile() throws IOException {
        String fileName = "save.txt";
        _saveFile = new File(fileName);
        Board board = new Board();

        boolean doesFileExist = doesFileExist(_saveFile);

        if (!doesFileExist) {
            _saveFile.createNewFile();
            // TODO
        } else {
            // TODO
        }
        _logger.log(Level.INFO, "Open the save file and retrieve the lastest state of the board.");
        return board;
    }

    private boolean doesFileExist(File file) {
        return file.exists();
    }
}
