package src.main.java.CommandReader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import src.main.java.GameData;
import src.main.java.FileReader.ReadJsonDoc;
import src.main.java.ItemsAndEquipment.Armor;
import src.main.java.ItemsAndEquipment.Equipment;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.ItemsAndEquipment.Weapon;
import src.main.java.WorldMap.Location;
import src.org.json.JSONObject;

public class LoadCommand {
    public static void load(GameData dataBase) {
        String canonPath;
        try {
            canonPath = new File(".").getCanonicalPath();
            String pathToSaveFile = canonPath + "/src/main/java/JsonFiles/Save.json";
            if (!Files.exists(Paths.get(pathToSaveFile))) {
                System.out.println("There are no save files found. Please save first!");
                return;
            }
            JSONObject saveData = new JSONObject(ReadJsonDoc.readObject(pathToSaveFile));
            Map<String, JSONObject> saveDataList = ReadJsonDoc.mapIterator(saveData);

            dataBase.Player.Health = saveDataList.get("Player").getInt("Health");
            dataBase.Player.MaxHealth = saveDataList.get("Player").getInt("MaxHealth");

            /* This block is dedicated to inventory. Comment below when it ends. */

            dataBase.Player.Inventory = new ArrayList<>();
            JSONObject inventoryObject = saveDataList.get("Player").getJSONObject("Inventory");

            for (String itemKey : inventoryObject.keySet()) {
                JSONObject itemObject = inventoryObject.getJSONObject(itemKey);
                String itemName = itemObject.getString("Name");
                String itemDescription = itemObject.getString("Description");
                if (itemObject.getString("Type").equals("Weapon")) {
                    int itemDamageMin = itemObject.getInt("DamageOutputMin");
                    int itemDamageMax = itemObject.getInt("DamageOutputMax");
                    dataBase.Player.Inventory.add(new Weapon(itemName, itemDamageMin, itemDamageMax, itemDescription));
                } else if (itemObject.getString("Type").equals("Armor")) {
                    int itemDefence = itemObject.getInt("Defence");
                    dataBase.Player.Inventory.add(new Armor(itemName, itemDefence, itemDescription));
                } else {
                    dataBase.Player.Inventory.add(new Item(itemName, itemDescription));
                }
            }

            JSONObject equippedArmorObject = saveDataList.get("Player").getJSONObject("EquippedArmor");
            dataBase.Player.EquippedArmor = new Armor(equippedArmorObject.getString("Name"),
                    equippedArmorObject.getInt("Defence"),
                    equippedArmorObject.getString("Description"));
            dataBase.Player.EquippedArmor.IsEquipped = true;

            JSONObject equippedWeaponObject = saveDataList.get("Player").getJSONObject("EquippedWeapon");
            dataBase.Player.EquippedWeapon = new Weapon(equippedWeaponObject.getString("Name"),
                    equippedWeaponObject.getInt("DamageOutputMin"),
                    equippedWeaponObject.getInt("DamageOutputMax"), equippedWeaponObject.getString("Description"));
            dataBase.Player.EquippedWeapon.IsEquipped = true;

            for (Item item : dataBase.Player.Inventory) {
                if (item instanceof Equipment) {
                    Equipment instanceItem = (Equipment) item;
                    if (instanceItem instanceof Weapon) {
                        if (item.Name.equals(dataBase.Player.EquippedWeapon.Name)) {
                            instanceItem.IsEquipped = true;
                        }
                    } else {
                        if (item.Name.equals(dataBase.Player.EquippedArmor.Name)) {
                            instanceItem.IsEquipped = true;
                        }
                    }
                }
            }

            /* Inventory Finished. */

            /* Related to Current Location Coordinates */
            JSONObject currentLocationObject = saveDataList.get("CurrentLocation");
            dataBase.CurrentLocation = new ArrayList<>();
            dataBase.CurrentLocation.add(currentLocationObject.getInt("XAxis"));
            dataBase.CurrentLocation.add(currentLocationObject.getInt("YAxis"));

            /* Related to Locations */
            JSONObject worldLocationObject = saveDataList.get("Location");
            for (String locationKey : worldLocationObject.keySet()) {
                JSONObject locationObject = worldLocationObject.getJSONObject(locationKey);
                for (Location place : dataBase.WorldLocation) {
                    if (place.Coordinates.equals(locationObject.getJSONArray("Coordinates").toList())) {
                        place.Entities.equals(locationObject.getJSONObject("Entities"));
                        place.Items.equals(locationObject.getJSONArray("Items").toList());
                        place.IsPassable.equals(locationObject.getBoolean("IsPassable"));
                    }
                }
            }
            System.out.println("File Load Completed!");

            // dataBase.Player.Health = (int) saveDataList.get("Player").get("Health");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
