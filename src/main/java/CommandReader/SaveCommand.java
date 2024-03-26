package src.main.java.CommandReader;

import java.lang.reflect.Field;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import src.org.json.*;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;
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
            JSONObject playerObject = new JSONObject();
            JSONObject currentLocationObject = new JSONObject();

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

            JSONObject playerInventoryObject = new JSONObject();
            for (Item item : dataBase.Player.Inventory) {
                playerInventoryObject.put(item.Name, saveJsonObject(item));
            }
            playerObject.put("Inventory", playerInventoryObject);
            playerObject.put("EquippedWeapon", saveJsonObject(dataBase.Player.EquippedWeapon));
            playerObject.put("EquippedArmor", saveJsonObject(dataBase.Player.EquippedArmor));
            playerObject.put("Health", dataBase.Player.Health);
            playerObject.put("MaxHealth", dataBase.Player.MaxHealth);
            playerObject.put("Name", dataBase.Player.Name);

            baseObject.put("Location", locationObject);
            baseObject.put("Player", playerObject);
            baseObject.put("CurrentLocation", currentLocationObject);

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
