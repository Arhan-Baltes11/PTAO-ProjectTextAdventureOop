package src.main.java.CommandReader;

import java.io.File;
import java.util.ArrayList;

import src.main.java.GameData;
import src.main.java.FileReader.ReadJsonDoc;
import src.org.json.JSONObject;

public class LoadCommand {
    public static void load(GameData dataBase) {
        String canonPath;
        try {
            canonPath = new File(".").getCanonicalPath();
            String pathToSaveFile = canonPath + "/src/main/java/JsonFiles/Save.json";
            JSONObject saveData = new JSONObject(ReadJsonDoc.readObject(pathToSaveFile));
            ArrayList<JSONObject> saveDataList = ReadJsonDoc.fileIterator(saveData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
