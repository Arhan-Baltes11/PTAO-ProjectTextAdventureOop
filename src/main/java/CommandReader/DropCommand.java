package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Equipment;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.WorldMap.Location;

public class DropCommand {
    protected static void drop(GameData dataBase, String command) {
        command = command.replace("drop ", "");
        command = ".*" + command + ".*";
        for (Item item : dataBase.Player.Inventory) {
            if (item.Name.toLowerCase().matches(command)) {
                if (item instanceof Equipment) {
                    Equipment equippedItem = (Equipment) item;
                    if (equippedItem.IsEquipped) {
                        System.out.println("You cannot drop an equipped item! Unequip it first!");
                        return;
                    }
                }
                dataBase.Player.Inventory.remove(item);
                for (Location location : dataBase.WorldLocation) {
                    if (location.Coordinates.equals(dataBase.CurrentLocation)) {
                        location.Items.add(item);
                        System.out.println("Dropped " + item.Name);
                        return;
                    }
                }
            }
        }
    }
}

