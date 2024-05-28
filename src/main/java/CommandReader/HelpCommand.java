package src.main.java.CommandReader;

import java.util.Scanner;

public class HelpCommand {
    protected static void help(Scanner scanner) {
        System.out.println("Welcome to the help tab!");
        System.out.println("Type exit to return back.");
        System.out.println("Your objective is to get rid of the Elder Beast that resides on the square (14,3).");
        System.out.println("In order to find the items required to banish it, you need three things:");
        System.out.println("A Kraken's Tongue, a Cornerstone and A Piece of Silver.");
        System.out.println("Type the following:");
        System.out.println("Commands = gives you a list of commands.");
        System.out.println("(Name of Previously Listed Item) = Find the location of the item (SPOILER!)");
        System.out.println("Exit = Exits the help tab.");
        while (true) {
            String helpCommand = scanner.nextLine();
            if (helpCommand.equals("Commands")) {
                commandsList();
            } else if (helpCommand.equals("Exit")) {
                break;
            } else {
                itemFinder(helpCommand);
            }
        }
    }

    private static void commandsList() {
        System.out.println("Attack = (Attack (Entity Name)) Attacks A designated enemy.");
        System.out.println("Banish = (Banish) If you are present where the Elder Beast is, win the game.");
        System.out.println(
                "Drop = (Drop (Item Name)) Drops the item from your inventory. Has to be unequipped if it's either a weapon or a piece of armor.");
        System.out.println("Equip = (Equip (Equippable Item) Equips either a weapon or a piece of armor.)");
        System.out.println(
                "Go = (Go (Direction (North/South/East/West))) Travel in the designated direction. If you hit a wall or mountain, return to your previous location.");
        System.out.println("Help = (Help) Brings you to the help screen.");
        System.out.println(
                "Inspect = (Inspect (Item Name in Inventory) Inspects the designated item in your inventory.)");
        System.out.println("Inventory = (Inventory) looks at your inventory.");
        System.out.println("Load = (Load) Reloads you to the previously created save file.");
        System.out.println(
                "Look = (Look (Direction (North/South/East/West/Around))) Look at the designated direction. Or, to look around, use 'Look Aronud'");
        System.out.println("Pickup = (Pickup (Item on Ground)) Picks up an item that is at your location.");
        System.out.println("Quit = (Quit) Quits the game. If you haven't saved, it will give you a confirmation.");
        System.out.println("Save = (Save) Saves the game.");
        System.out.println(
                "Talk = (Talk (Name of entity at your location)) Talks to a being that can be found at that location.");
        System.out.println("Unequip = (Unequip (Name of Equipped Item)) unequips a weapon or piece of armor");
        System.out.println("Use = (Use (Name of Item)) uses an item in your inventory.");
    }

    private static void itemFinder(String itemName) {
        itemName = itemName.toLowerCase();
        String selectedItem = "";
        switch (itemName) {
            case "kraken's tongue":
                selectedItem = "The Kraken's Tongue can be found at (X = 6, Y = 7)";
                break;
            case "cornerstone":
                selectedItem = "The Cornerstone can be found at (X = 15, Y = 15)";
                break;
            case "a piece of silver":
                selectedItem = "A Piece of Silver can be found at (X = 11, Y = 7))";
                break;
            default:
                selectedItem = "Unrecognized Item";
                break;

        }
        System.out.println(selectedItem);
    }
}
