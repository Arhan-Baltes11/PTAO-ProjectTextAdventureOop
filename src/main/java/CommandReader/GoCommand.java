package src.main.java.CommandReader;

import java.util.ArrayList;

import src.main.java.GameData;
import src.main.java.WorldMap.Location;

public class GoCommand {
    protected static void go(String direction, GameData dataBase) {

        ArrayList<Integer> travelCoordinates = new ArrayList<>();

        switch (direction) {
            case "north":
                if (locationLimiter(-1, dataBase.CurrentLocation.get(1))) {
                    travelCoordinates.add(dataBase.CurrentLocation.get(0));
                    travelCoordinates.add(dataBase.CurrentLocation.get(1) - 1);
                    if (passThrough(dataBase.WorldLocation, travelCoordinates)) {
                        dataBase.CurrentLocation.set(1, dataBase.CurrentLocation.get(1) - 1);
                    }
                }
                break;
            case "south":
                if (locationLimiter(1, dataBase.CurrentLocation.get(1))) {
                    travelCoordinates.add(dataBase.CurrentLocation.get(0));
                    travelCoordinates.add(dataBase.CurrentLocation.get(1) + 1);
                    if (passThrough(dataBase.WorldLocation, travelCoordinates)) {
                        dataBase.CurrentLocation.set(1, dataBase.CurrentLocation.get(1) + 1);
                    }
                }
                break;
            case "west":
                if (locationLimiter(-1, dataBase.CurrentLocation.get(0))) {
                    if (locationLimiter(1, dataBase.CurrentLocation.get(1))) {
                        travelCoordinates.add(dataBase.CurrentLocation.get(0) - 1);
                        travelCoordinates.add(dataBase.CurrentLocation.get(1));
                        if (passThrough(dataBase.WorldLocation, travelCoordinates)) {
                            dataBase.CurrentLocation.set(0, dataBase.CurrentLocation.get(0) - 1);
                        }
                    }
                }
                break;
            case "east":
                if (locationLimiter(1, dataBase.CurrentLocation.get(0))) {
                    if (locationLimiter(1, dataBase.CurrentLocation.get(1))) {
                        travelCoordinates.add(dataBase.CurrentLocation.get(0) + 1);
                        travelCoordinates.add(dataBase.CurrentLocation.get(1));
                        if (passThrough(dataBase.WorldLocation, travelCoordinates)) {
                            dataBase.CurrentLocation.set(0, dataBase.CurrentLocation.get(0) + 1);
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid Direction");
                break;
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
                } else {
                    System.out.println("You hit a " + place.Type + " that you cannot pass through.");
                    return false;
                }
            }
        }
        return false;
    }
}
