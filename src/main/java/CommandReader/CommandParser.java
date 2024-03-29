package src.main.java.CommandReader;

import java.util.Scanner;

import src.main.java.GameData;

/*
 * This commandparser is there to load commands.
 * Most of the static commands are protected in the CommandReader file.
 */
public class CommandParser {

    public void commandGet(String command, GameData dataBase) {
        command = command.toLowerCase();
        String[] parsedInfo = command.split(" ");
        if (parsedInfo[0].equals("go")) {
            GoCommand.go(dataBase, parsedInfo[1]);
        }
        else if (parsedInfo[0].equals("look")) {
            LookCommand.look(dataBase, parsedInfo[1]);
        }
        else if (parsedInfo[0].equals("inventory")) {
            InventoryCommand.checkInventory(dataBase);
        }
        else if (parsedInfo[0].equals("equip")) {
            EquipCommand.equip(dataBase, command);
        }
        else if (parsedInfo[0].equals("unequip")) {
            EquipCommand.unequip(dataBase, command);
        }
        else if (parsedInfo[0].equals("drop")) {
            DropCommand.drop(dataBase, command);
        }
        else if (parsedInfo[0].equals("pickup")) {
            PickupCommand.pickup(dataBase, command);
        }
        else if (parsedInfo[0].equals("talk")) {
            TalkCommand.talk(dataBase, command);
        }
        else if (parsedInfo[0].equals("use")) {
            UseCommand.use(dataBase, command);
        }
        else if (parsedInfo[0].equals("inspect")) {
            InspectCommand.inspect(dataBase, command);
        }
        else if (parsedInfo[0].equals("attack")) {
            AttackCommand.attack(dataBase, command);
        }
        else if (parsedInfo[0].equals("banish")) {
            BanishCommand.banish(dataBase);
        }
        else if (parsedInfo[0].equals("save")) {
            SaveCommand.save(dataBase);
        }
        else if (parsedInfo[0].equals("load")) {
            LoadCommand.load(dataBase);
        } else {
            System.out.println("I don't know how to do that. Am I missing something?");
        }
    }

    public void scanCommand(Scanner scanner, String commString) {
        commString = commString.toLowerCase();
        if (commString.equals("quit")) {
            QuitCommand.quit(scanner);
        } else if (commString.equals("help")) {
            HelpCommand.help(scanner);
        }
    }
}
