package src.main.java.CommandReader;

import java.util.ArrayList;

import src.main.java.GameData;
import src.main.java.WorldMap.Location;

public class CommandParser {

    public void commandGet(String command, GameData dataBase) {
        String[] parsedInfo = command.split(" ");
        if (parsedInfo[0].toLowerCase().equals("go")) {
            go(parsedInfo[1].toLowerCase(), dataBase);
        }
    }

    public void commandResolve(Object action) {
        System.out.println(action.getClass().getCanonicalName());
    }

    private void go(String direction, GameData dataBase) {

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

    private boolean locationLimiter(int toChange, int indexValue) {
        if (indexValue + toChange == 0 || indexValue + toChange == 16) {
                System.out.println("Cannot go that way.");
                return false;
            } else {
                return true;
            }
        }

        private boolean passThrough(ArrayList<Location> locations, ArrayList<Integer> nextLocation) {

            for (Location place : locations) {
                if (place.Coordinates.equals(nextLocation)) {
                    if (place.IsPassable) {
                        return true;
                    } else {
                    System.out.println("You cannot pass through this location.");
                    return false;
                }
            }
        }
        return false;
    }

    private void attackEnemy() {

    }
}
