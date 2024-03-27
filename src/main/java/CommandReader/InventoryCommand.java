package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Equipment;
import src.main.java.ItemsAndEquipment.Item;

public class InventoryCommand {
    protected static void checkInventory(GameData dataBase) {

        System.out.println("Your Inventory Contains " + dataBase.Player.Inventory.size() + " Items");
        for (Item item : dataBase.Player.Inventory) {
            String itemInInventory = item.Name;
            String itemDescription = item.Description;
            if (item instanceof Equipment) {
                Equipment isEquip = (Equipment) item;
                if (isEquip.IsEquipped) {
                    itemInInventory += "(e)";
                }
            }
            System.out.println("(" + item.Type + ") " + itemInInventory + ", " + itemDescription);
        }
    }
}
