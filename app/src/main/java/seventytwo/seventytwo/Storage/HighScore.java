package seventytwo.seventytwo.Storage;

import java.io.File;
import java.io.IOException;

/**
 * Created by dongu on 10/12/2015.
 * This class contains the highest score.
 */
public class HighScore {
    // Attribute
    private File _saveFile;

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

        return highScore;
    }

    private boolean doesFileExist(File file) {
        return file.exists();
    }
}
