package src.main.java.CommandReader;

import java.util.ArrayList;


import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.WorldMap.Location;
import src.main.java.Entities.Entity;

// Look at a direction.
public class LookCommand {
    protected static void look(GameData dataBase, String direction) {
        switch (direction) {
            case "north":
                findArea(dataBase, false, true);
                break;
            case "south":
                findArea(dataBase, false, false);
                break;
            case "east":
                findArea(dataBase, true, false);
                break;
            case "west":
                findArea(dataBase, true, true);
                break;
            case "around":
                lookHere(dataBase);
                break;
            default:
                System.out.println("I cannot see that place from here.");
                break;
        }
    }

    private static void lookHere(GameData dataBase) {
        for (Location place : dataBase.WorldLocation) {
            if (place.Coordinates.equals(dataBase.CurrentLocation)) {
                describeArea(place);
                return;
            }
        }
    }

    private static void findArea(GameData dataBase, boolean isHorizontal, boolean isNegative) {
        ArrayList<Integer> lookLocation = new ArrayList<>();
        int numberChange = isNegative ? -1 : 1;
        if (!isHorizontal) {
            lookLocation.add(dataBase.CurrentLocation.get(0));
            lookLocation.add(dataBase.CurrentLocation.get(1) + numberChange);
        } else {
            lookLocation.add(dataBase.CurrentLocation.get(0) + numberChange);
            lookLocation.add(dataBase.CurrentLocation.get(1));
        }
        for (Location place : dataBase.WorldLocation) {
            if (place.Coordinates.equals(lookLocation)) {
                describeArea(place);
                return;
            }
        }
    }

    private static void describeArea(Location location) {
        System.out.println("");
        System.out.println(
                "The Coordinates are: X: " + location.Coordinates.get(0) + " Y: " + location.Coordinates.get(1));
        System.out.println("The Ground Type is = " + location.Type);
        System.out.println(
                location.IsPassable ? "You can pass through this place" : "You cannot pass through this place");
        System.out.println("The following items can be found on this location:");
        if (location.Items.size() != 0) {
            for (Item item : location.Items) {
                System.out.println(item.Name + ", " + item.Description);
            }
        } else {
            System.out.println("Nothing");
        }
        System.out.println("The following entities can be found on this location:");
        if (location.Entities.size() != 0) {
            for (Entity being : location.Entities) {
                System.out.println(being.Name);
            }
        } else {
            System.out.println("Nothing");
        }
        System.out.println("");
    }
}
