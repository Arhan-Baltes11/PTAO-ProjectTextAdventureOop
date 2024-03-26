package src.main.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import src.main.java.CommandReader.LoadCommand;

public class SafeFileHandler {

    public static void saveFileHandler(GameData dataBase) {
        String canonPath;
        try {
            canonPath = new File(".").getCanonicalPath();
            String pathToSaveFile = canonPath + "/src/main/java/JsonFiles/Save.json";
            if (!Files.exists(Paths.get(pathToSaveFile))) {
                return;
            } else {
                LoadCommand.load(dataBase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
