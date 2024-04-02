package src.main.java.CommandReader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import src.main.java.GameData;
import src.main.java.Entities.Entity;
import src.main.java.Entities.Hostile.ElderBeast;
import src.main.java.Entities.Neutral.Merchant;
import src.main.java.Entities.Neutral.RiverKing;
import src.main.java.FileReader.ReadJsonDoc;
import src.main.java.ItemsAndEquipment.Armor;
import src.main.java.ItemsAndEquipment.Equipment;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.ItemsAndEquipment.Weapon;
import src.main.java.ItemsAndEquipment.UsableItems.EngravedKey;
import src.main.java.ItemsAndEquipment.UsableItems.HealingPotion;
import src.main.java.WorldMap.Location;
import src.org.json.JSONObject;

/*
 * This entire command is dedicated to loading a save file.
 * Needs refinement for future ideas.
 */

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
                } else if (itemObject.getString("Type").equals("Healing Potion")) {
                    int itemHealthAmount = itemObject.getInt("HealingAmount");
                    dataBase.Player.Inventory.add(new HealingPotion(itemName, itemDescription, itemHealthAmount));

                } else if (itemObject.getString("Type").equals("Engraved Key")) {
                    dataBase.Player.Inventory.add(new EngravedKey(itemName, itemDescription));
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
            for (Location place : dataBase.WorldLocation) {
                for (String locationKey : worldLocationObject.keySet()) {
                    JSONObject locationObject = worldLocationObject.getJSONObject(locationKey);
                    JSONObject coordinatesObject = locationObject.getJSONObject("Coordinates");
                    JSONObject entitiesObject = locationObject.getJSONObject("Entities");
                    JSONObject itemsObject = locationObject.getJSONObject("Items");

                    if (place.Coordinates.get(0).equals(coordinatesObject.get("XAxis"))
                            && place.Coordinates.get(1).equals(coordinatesObject.get("YAxis"))) {
                        place.Entities = entityCreator(entitiesObject);
                        place.Items = itemCreator(itemsObject);
                        place.IsPassable = locationObject.getBoolean("IsPassable");
                        place.Type = locationObject.getString("Type");
                        break;
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

    private static ArrayList<Item> itemCreator(JSONObject itemsObject) {
        ArrayList<Item> itemsList = new ArrayList<>();
        if (!itemsObject.isEmpty()) {
            for (int i = 1; i <= itemsObject.length(); i++) {
                JSONObject innerObject = itemsObject.getJSONObject("Object" + i);
                String objectType = innerObject.getString("Type");
                String objectName = innerObject.getString("Name");
                String objectDescription = innerObject.getString("Description");
                if (objectType.equals("Weapon")) {
                    int objectDamageOutputMin = innerObject.getInt("DamageOutputMin");
                    int objectDamageOutputMax = innerObject.getInt("DamageOutputMax");
                    itemsList.add(
                            new Weapon(objectName, objectDamageOutputMin, objectDamageOutputMax, objectDescription));
                } else if (objectType.equals("Armor")) {
                    int objectDefence = innerObject.getInt("Defence");
                    itemsList.add(new Armor(objectName, objectDefence, objectDescription));
                } else if (objectType.equals("Healing Potion")) {
                    int healingAmountObject = innerObject.getInt("Healing Amount");
                    itemsList.add(new HealingPotion(objectName, objectDescription, healingAmountObject));
                } else if (objectType.equals("Engraved Key")) {
                    itemsList.add(new EngravedKey(objectName, objectDescription));
                } else {
                    itemsList.add(new Item(objectName, objectDescription));
                }
            }
        }
        return itemsList;
    }

    private static ArrayList<Entity> entityCreator(JSONObject entityObject) {
        ArrayList<Entity> entitiesList = new ArrayList<>();

        for (int i = 1; i <= entityObject.length(); i++) {
            JSONObject innerObject = entityObject.getJSONObject("Object" + i);
            String objectName = innerObject.getString("Name");
            int objectHealth = innerObject.getInt("Health");
            int objectAttackMin = innerObject.getInt("AttackMin");
            int objectAttackMax = innerObject.getInt("AttackMax");

            if (objectName.equals("Elder Beast")) {
                entitiesList.add(new ElderBeast(objectName, objectHealth,
                        objectAttackMin, objectAttackMax));
            } else if (objectName.equals("Armed Merchant")) {
                entitiesList.add(new Merchant(objectName, objectHealth, objectAttackMin, objectAttackMax));
            } else if (objectName.equals("River King")) {
                entitiesList.add(new RiverKing(objectName, objectHealth, objectAttackMin, objectAttackMax));
            } else {
                entitiesList.add(new Entity(objectName, objectHealth, objectAttackMin, objectAttackMax));
            }
        }

        return entitiesList;
    }
}
