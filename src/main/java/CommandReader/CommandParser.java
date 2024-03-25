package src.main.java.CommandReader;

import java.util.ArrayList;

import src.main.java.GameData;

public class CommandParser {

    public void commandGet(String command, GameData dataBase) {
        String[] parsedInfo = command.split(" ");
        if (parsedInfo[0].toLowerCase().equals("go")) {
            GoCommand.go(parsedInfo[1].toLowerCase(), dataBase);
        }
        if (parsedInfo[0].toLowerCase().equals("inventory")) {
            InventoryCommand.checkInventory(dataBase);
        }
    }


    private void attackEnemy() {

    }
}
