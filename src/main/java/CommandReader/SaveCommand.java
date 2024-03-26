package src.main.java.CommandReader;

import java.lang.reflect.Field;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import src.org.json.*;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.Entities.Entity;
import src.main.java.WorldMap.Location;

public class SaveCommand {
    protected static void save(GameData dataBase) {
        try {
            String canonPath = new File(".").getCanonicalPath();
            String pathToSaveFile = canonPath + "/src/main/java/JsonFiles/Save.json";
            File saveJson = new File(pathToSaveFile);
            if (!Files.exists(Paths.get(pathToSaveFile))) {
                saveJson.createNewFile();
            }

            JSONObject baseObject = new JSONObject();
            JSONObject locationObject = new JSONObject();
            JSONObject currentLocationObject = new JSONObject();

            JSONArray entitiesOnLocationObject = new JSONArray();
            JSONArray itemsOnGroundObject = new JSONArray();

            if (dataBase.ItemsOnGround != null) {
                for (Item item : dataBase.ItemsOnGround) {
                    JSONObject itemObject = saveJsonObject(item);
                    entitiesOnLocationObject.put(itemObject);
                }
            }

            if (dataBase.EntitiesOnLocation != null) {
                for (Entity being : dataBase.EntitiesOnLocation) {
                    JSONObject entityObject = saveJsonObject(being);
                    entitiesOnLocationObject.put(entityObject);
                }
            }

            for (Location place : dataBase.WorldLocation) {
                locationObject.put("Grid " + place.Coordinates.toString(), saveJsonObject(place));
            }
            for (int i = 0; i < dataBase.CurrentLocation.size(); i++) {
                String selectedAxis = "";
                if (i == 0) {
                    selectedAxis = "X";
                } else {
                    selectedAxis = "Y";
                }
                currentLocationObject.put(selectedAxis + "Axis", dataBase.CurrentLocation.get(i));
            }

            baseObject.put("Location", locationObject);
            baseObject.put("Player", saveJsonObject(dataBase.Player));
            baseObject.put("CurrentLocation", currentLocationObject);
            baseObject.put("EntitiesOnLocation", entitiesOnLocationObject);
            baseObject.put("ItemsOnGround", itemsOnGroundObject);

            FileWriter fileWriter = new FileWriter(pathToSaveFile);
            fileWriter.write(baseObject.toString());
            fileWriter.close();
            return;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject saveJsonObject(Object transfer) {
        JSONObject arrayFileSave = new JSONObject();
        Field[] fields = transfer.getClass().getFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                arrayFileSave.put(field.getName(), field.get(transfer));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return arrayFileSave;
    }
}
