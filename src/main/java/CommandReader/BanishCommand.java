package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.Entities.Entity;
import src.main.java.Entities.Hostile.ElderBeast;
import src.main.java.ItemsAndEquipment.Item;

public class BanishCommand {
    protected static void banish(GameData dataBase) {
        int requiredItems = 0;

        for (Item item : dataBase.Player.Inventory) {
            if (item.Name.equals("Cornerstone") || item.Name.equals("Kraken's Tongue")
                    || item.Name.equals("A Piece of Silver")) {
                requiredItems++;
            }
        }
        if (dataBase.EntitiesOnLocation != null) {
            for (Entity being : dataBase.EntitiesOnLocation) {

                if (requiredItems == 3 && being instanceof ElderBeast) {
                    System.out.println("With the power granted to you, you banish the great beast!");
                    being.Health = 0;
                    System.out.println("You have completed the game!");
                    System.out.println("Your save file can be removed freely, or persist in a dead world.");
                } else {
                    System.out.println(
                            "You attempt to use the power, but fail... could it be that you're missing something?");
                }
            }
        } else {
            System.out.println("There are no creatures to banish...");
        }
    }
}
