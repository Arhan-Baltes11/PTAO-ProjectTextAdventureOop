package src.main.java.CommandReader;

import src.main.java.GameData;

public class CommandParser {

    public void commandGet(String command, GameData dataBase) {
        String[] parsedInfo = command.split(" ");
        if (parsedInfo[0].toLowerCase() == "go") {
            go(parsedInfo[1].toLowerCase(), dataBase);
        }
        dataBase.CurrentLocation.set(0, dataBase.CurrentLocation.get(0) + 1);
    }

    public void commandResolve(Object action) {
        System.out.println(action.getClass().getCanonicalName());
    }

    private void go(String direction, GameData dataBase) {
        switch (direction) {
            case "north":
                dataBase.CurrentLocation.set(1, dataBase.CurrentLocation.get(1) - 1);
                break;
            case "south":
                dataBase.CurrentLocation.set(1, dataBase.CurrentLocation.get(1) + 1);
                break;
            case "west":
                dataBase.CurrentLocation.set(0, dataBase.CurrentLocation.get(0) - 1);
                break;
            case "east":
                dataBase.CurrentLocation.set(0, dataBase.CurrentLocation.get(0) + 1);
                break;
            default:
                System.out.println("Invalid Direction");
                break;
        }
    }

    private void attackEnemy() {

    }
}
