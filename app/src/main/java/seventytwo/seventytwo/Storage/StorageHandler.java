package seventytwo.seventytwo.Storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;

/**
 * Created by dongu on 15/12/2015.
 * This class handles the writing and reading of save file.
 */
public class StorageHandler {

    private File _boardStorage;
    private File _highScoreStorage;
    private static Logger _logger = GlobalLogger.getInstance().getLogger();

    public StorageHandler() {
    }

    public ArrayList<String> openSaveFile() throws IOException {
        String fileNameOne = "boardSave.txt";
        String fileNameTwo = "scoreSave.txt";
        _boardStorage = new File(fileNameOne);
        _highScoreStorage = new File(fileNameTwo);

        ArrayList<String> saveContent = new ArrayList<>();

        if (!doesFileExist(_boardStorage)) {
            _boardStorage.createNewFile();
            saveContent.add("0");
            _logger.log(Level.INFO, "Create a new save file and return last game state.");
        } else {
            Scanner sc = new Scanner(_boardStorage);
            while (sc.hasNext()) {
                saveContent.add(sc.nextLine());
            }
            _logger.log(Level.INFO, "Open the existing board save file.");
        }

        if (!doesFileExist(_highScoreStorage)) {
            _highScoreStorage.createNewFile();
            saveContent.add("0");
            _logger.log(Level.INFO, "Create a new save file for high score.");
        } else {
            Scanner sc = new Scanner(_highScoreStorage);
            while (sc.hasNext()) {
                saveContent.add(sc.nextLine());
            }
            _logger.log(Level.INFO, "Open the existing score save file.");
        }

        return saveContent;
    }

    private boolean doesFileExist(File file) {
        return file.exists();
    }

    public void transferTempStorageToFile(ArrayList<String> saveContent) throws IOException {
        FileWriter fileOne = new FileWriter(_boardStorage);
        FileWriter fileTwo = new FileWriter(_highScoreStorage);
        copyContentToFile(fileOne, saveContent, 0);
        copyContentToFile(fileTwo, saveContent, 1);
        fileOne.close();
        fileTwo.close();
        _logger.log(Level.INFO, "Copy all save contents into save file.");
    }

    private void copyContentToFile(FileWriter file, ArrayList<String> saveContent, int number) throws IOException {
        String content = saveContent.get(number);
        file.write(content);
        file.write("\n");
        file.flush();
    }
}
