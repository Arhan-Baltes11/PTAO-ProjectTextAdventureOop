package src.main.java.CommandReader;

import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.GameData;

public class CommandParser {

    public void commandGet(String command, GameData dataBase) {
        command = command.toLowerCase();
        String[] parsedInfo = command.split(" ");
        if (parsedInfo[0].equals("go")) {
            GoCommand.go(dataBase, parsedInfo[1]);
        }
        if (parsedInfo[0].equals("look")) {
            LookCommand.look(dataBase, parsedInfo[1]);
        }
        if (parsedInfo[0].equals("inventory")) {
            InventoryCommand.checkInventory(dataBase);
        }
        if (parsedInfo[0].equals("equip")) {
            EquipCommand.equip(dataBase, command);
        }
        if (parsedInfo[0].equals("drop")) {
            DropCommand.drop(dataBase, command);
        }
        if (parsedInfo[0].equals("pickup")) {
            PickupCommand.pickup(dataBase, command);
        }
        if (parsedInfo[0].equals("talk")) {
            TalkCommand.talk(dataBase, command);
        }
        if (parsedInfo[0].equals("use")) {
            UseCommand.use(dataBase, command);
        }
        if (parsedInfo[0].equals("inspect")) {
            InspectCommand.inspect(dataBase, command);
        }
        if (parsedInfo[0].equals("attack")) {
            AttackCommand.attack(dataBase, command);
        }
    }
}
