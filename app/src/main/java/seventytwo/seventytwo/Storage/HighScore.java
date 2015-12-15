package seventytwo.seventytwo.Storage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;

/**
 * Created by dongu on 10/12/2015.
 * This class contains the highest score.
 */
public class HighScore {
    // Attribute
    private File _saveFile;

    private static Logger _logger = GlobalLogger.getInstance().getLogger();
    // Constructor

    public HighScore() {
    }

    public int openSaveFile() throws IOException {
        String fileName = "save.txt";
        _saveFile = new File(fileName);
        int highScore = 0;

        boolean doesFileExist = doesFileExist(_saveFile);

        if (!doesFileExist) {
            _saveFile.createNewFile();
            // TODO
        } else {
            // TODO
        }
        _logger.log(Level.INFO, "Open the save file and get the high score.");
        return highScore;
    }

    private boolean doesFileExist(File file) {
        return file.exists();
    }
}
