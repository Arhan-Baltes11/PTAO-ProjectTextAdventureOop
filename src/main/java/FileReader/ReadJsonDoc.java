package src.main.java.FileReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import src.org.json.JSONObject;

public class ReadJsonDoc {
    public static JSONObject readObject(String filePath) {
        try {
            String fileContents = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonToRefer = new JSONObject(fileContents);
            return jsonToRefer;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
