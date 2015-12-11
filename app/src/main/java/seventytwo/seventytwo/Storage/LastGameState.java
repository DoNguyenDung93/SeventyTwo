package seventytwo.seventytwo.Storage;

import java.io.File;
import java.io.IOException;

import seventytwo.seventytwo.Component.Board;

/**
 * Created by dongu on 10/12/2015.
 * This class remembers the last game state so that the user will be able to continue the last game.
 */
public class LastGameState {

    // Attribute
    private File _saveFile;

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

        return board;
    }

    private boolean doesFileExist(File file) {
        return file.exists();
    }
}
