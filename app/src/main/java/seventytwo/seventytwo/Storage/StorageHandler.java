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

    private File _storage;
    private static Logger _logger = GlobalLogger.getInstance().getLogger();

    public StorageHandler() {
    }

    public ArrayList<String> openSaveFile() throws IOException {
        String fileName = "save.txt";
        _storage = new File(fileName);
        boolean doesFileExist = doesFileExist(_storage);

        ArrayList<String> saveContent = new ArrayList<>();

        if (!doesFileExist) {
            _storage.createNewFile();
            saveContent.add("0");
            saveContent.add("0");
            _logger.log(Level.INFO, "Create a new save file and return empty high score and last game state.");
        } else {
            Scanner sc = new Scanner(_storage);
            while (sc.hasNext()) {
                saveContent.add(sc.nextLine());
            }
            _logger.log(Level.INFO, "Open the existing save file.");
        }

        return saveContent;
    }

    private boolean doesFileExist(File file) {
        return file.exists();
    }

    public void transferTempStorageToFile(ArrayList<String> saveContent) throws IOException {
        FileWriter file = new FileWriter(_storage);
        copyAllContentToFile(file, saveContent);
        file.close();
        _logger.log(Level.INFO, "Copy all save contents into save file.");
    }

    private void copyAllContentToFile(FileWriter file, ArrayList<String> saveContent) throws IOException {
        for (int i = 0; i < saveContent.size(); i++) {
            String content = saveContent.get(i);
            file.write(content);
            file.write("\n");
            file.flush();
        }
    }
}
