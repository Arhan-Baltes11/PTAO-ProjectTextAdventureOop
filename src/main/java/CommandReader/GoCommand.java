package src.main.java.CommandReader;

import java.util.ArrayList;

import src.main.java.GameData;
import src.main.java.WorldMap.Location;

public class GoCommand {
    protected static void go(GameData dataBase, String direction) {

        ArrayList<Integer> travelCoordinates = new ArrayList<>();

        switch (direction) {
            case "north":
                interChanger(dataBase, false, true, travelCoordinates);
                break;
            case "south":
                interChanger(dataBase, false, false, travelCoordinates);
                break;
            case "west":
                interChanger(dataBase, true, true, travelCoordinates);
                break;
            case "east":
                interChanger(dataBase, true, false, travelCoordinates);
                break;
            default:
                System.out.println("Invalid Direction");
                break;
        }
    }

    private static void interChanger(GameData dataInner, boolean isHorizontal, boolean isNegative,
            ArrayList<Integer> travelCoordinates) {
        int selectedIndex = isHorizontal ? 0 : 1;
        int numberChange = isNegative ? -1 : 1;
        if (locationLimiter(numberChange, dataInner.CurrentLocation.get(selectedIndex))) {
            if (isHorizontal) {
                travelCoordinates.add(dataInner.CurrentLocation.get(0) + numberChange);
                travelCoordinates.add(dataInner.CurrentLocation.get(1));
            } else {
                travelCoordinates.add(dataInner.CurrentLocation.get(0));
                travelCoordinates.add(dataInner.CurrentLocation.get(1) + numberChange);
            }
            if (passThrough(dataInner.WorldLocation, travelCoordinates)) {
                if (isHorizontal) {
                    dataInner.CurrentLocation.set(0, dataInner.CurrentLocation.get(0) + numberChange);
                } else {
                    dataInner.CurrentLocation.set(1, dataInner.CurrentLocation.get(1) + numberChange);
                }
            }
        }
    }

    private static boolean locationLimiter(int toChange, int indexValue) {
        if (indexValue + toChange == 0 || indexValue + toChange == 16) {
            System.out.println("Now isn't the time to leave the area. You've got work to do!");
            return false;
        } else {
            return true;
        }
    }

    private static boolean passThrough(ArrayList<Location> locations, ArrayList<Integer> nextLocation) {

        for (Location place : locations) {
            if (place.Coordinates.equals(nextLocation)) {
                if (place.IsPassable) {
                    return true;
                } else if (place.Coordinates.get(0) == 8 && place.Coordinates.get(1) == 7 && !place.IsPassable) {
                    System.out.println("The door holds a stubborn lock. Only a key will let you pass it.");
                    return false;
                } else {
                    System.out.println("You hit a " + place.Type + " that you cannot pass through.");
                    return false;
                }
            }
        }
        return false;
    }
}
