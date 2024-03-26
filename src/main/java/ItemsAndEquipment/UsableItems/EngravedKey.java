package src.main.java.ItemsAndEquipment.UsableItems;

import java.util.ArrayList;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.WorldMap.Location;

public class EngravedKey extends Item {

    public EngravedKey(String iName, String iDescription) {
        super(iName, iDescription);
    }

    @Override
    public void useItem(GameData dataBase) {
        ArrayList<Integer> lockedLocation = new ArrayList<>();
        lockedLocation.add(8);
        lockedLocation.add(7);
        ArrayList<Integer> currentLocation = new ArrayList<>();
        currentLocation.add(8);
        currentLocation.add(8);
        if (dataBase.CurrentLocation.equals(currentLocation)) {
            for (Location place : dataBase.WorldLocation) {
                if (place.Coordinates.equals(lockedLocation)) {
                    place.IsPassable = true;
                    System.out.println("The key fits inside the door. The way ahead is unlocked!");
                    dataBase.Player.Inventory.remove(this);
                }
            }
        }
    }
}
