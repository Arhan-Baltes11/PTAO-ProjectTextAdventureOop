package src.main.java.CommandReader;

import src.main.java.GameData;

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
        switch (direction) {
            case "north":
                if (locationLimiter(-1, dataBase.CurrentLocation.get(1))) {
                dataBase.CurrentLocation.set(1, dataBase.CurrentLocation.get(1) - 1);
            }
            break;
            case "south":
                if (locationLimiter(1, dataBase.CurrentLocation.get(1))) {
                dataBase.CurrentLocation.set(1, dataBase.CurrentLocation.get(1) + 1);
            }
            break;
            case "west":
                if (locationLimiter(-1, dataBase.CurrentLocation.get(0))) {
                dataBase.CurrentLocation.set(0, dataBase.CurrentLocation.get(0) - 1);
            }
            break;
            case "east":
                if (locationLimiter(1, dataBase.CurrentLocation.get(0))) {
                dataBase.CurrentLocation.set(0, dataBase.CurrentLocation.get(0) + 1);
            }
            break;
            default:
                System.out.println("Invalid Direction");
                break;
        }
    }

    private boolean locationLimiter(int toChange, int indexValue) {
        if (toChange < 0) {

            if (indexValue + toChange == 0) {
                System.out.println("Cannot go that way.");
                return false;
            } else {
                return true;
            }
        } else {
            if (indexValue + toChange == 16) {
                System.out.println("Cannot go that way.");
                return false;
            } else {
                return true;
            }
        }
    }

    private void attackEnemy() {

    }
}
