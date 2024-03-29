package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.WorldMap.Location;

// Picks up items on the location.
public class PickupCommand {
    protected static void pickup(GameData dataBase, String command) {
        command = command.replace("pickup ", "");
        command = ".*" + command + ".*";
        for (Location place : dataBase.WorldLocation) {
            if (place.Coordinates.equals(dataBase.CurrentLocation)) {
                for (Item item : place.Items) {
                    if (item.Name.toLowerCase().matches(command)) {
                        dataBase.Player.Inventory.add(item);
                        place.Items.remove(item);
                        System.out.println("Picked up " + item.Name);
                        return;
                    }
                }
            }
        }
        System.out.println("What am I picking up? Am I seeing it right?");
    }
}
