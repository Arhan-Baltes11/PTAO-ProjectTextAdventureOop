package src.main.java.FileReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import src.org.json.JSONArray;
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

    public static void jsonLocationGrid(String filePath) {
        int[][] plains = { { 1, 9 }, { 1, 10 }, { 1, 11 }, { 1, 12 }, { 1, 13 }, { 2, 13 }, { 3, 7 }, { 3, 12 },
                { 3, 13 }, { 3, 14 }, { 4, 6 }, { 4, 7 }, { 4, 13 }, { 4, 14 }, { 4, 15 }, { 5, 2 }, { 5, 3 },
                { 5, 6 }, { 5, 12 }, { 5, 13 }, { 5, 14 }, { 5, 15 } };
        int[][] hills = { { 1, 6 }, { 1, 7 }, { 1, 8 }, { 1, 14 }, { 2, 6 }, { 2, 7 }, { 2, 14 }, { 3, 6 }, { 4, 5 },
                { 5, 5 }, { 5, 7 }, { 5, 12 }, {} };
        int[][] wall = { { 2, 8 }, { 2, 9 }, { 2, 10 }, { 2, 11 }, { 2, 12 }, { 3, 8 }, { 4, 8 }, { 4, 11 },
                { 4, 12 }, { 5, 8 }, { 5, 11 } };
        int[][] roomFloor = { { 3, 9 }, { 3, 10 }, { 4, 9 }, { 4, 10 }, { 5, 9 }, { 5, 10 } };
        int[][] cavern = { {} };
        int[][] river = { {} };

        for (int x = 1; x <= 15; x++) {
            for (int y = 1; y <= 15; y++) {
                JSONObject toWrite = new JSONObject();
                JSONArray coordinates = new JSONArray();
                JSONArray items = new JSONArray();
                JSONArray entities = new JSONArray();

                toWrite.put("Type", "Mountain");
                if (x == 3 & y == 13) {
                    toWrite.put("Type", "Doorway");
                }
                toWrite.put("Weather", "SnowStorm");
                toWrite.put("IsPassable", false);
                coordinates.put(x);
                coordinates.put(y);
                if (x == 15 && y == 1) {
                    items.put("Engraved Key");
                } else {
                    items.put("");
                }
                if (x == 14 && y == 3) {
                    entities.put("Elder Beast");
                } else if (x == 7 && y == 9) {
                    entities.put("Expositionist");
                } else {
                    entities.put("");
                }
            }
        }

    }
}
