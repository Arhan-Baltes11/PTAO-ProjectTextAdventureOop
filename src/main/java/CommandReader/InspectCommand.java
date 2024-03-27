package src.main.java.CommandReader;

import java.lang.reflect.Field;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Armor;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.ItemsAndEquipment.Weapon;

public class InspectCommand {
    protected static void inspect(GameData dataBase, String command) {
        command = command.replace("inspect ", "");
        command = ".*" + command + ".*";
        for (Item item : dataBase.Player.Inventory) {
            if (item.Name.toLowerCase().matches(command)) {
                mentionSelf(item);
                return;
            }
        }
    }

    private static void mentionSelf(Item item) {
        System.out.println("");
        System.out.println("The Item Name is this: " + item.Name);
        System.out.println("It is a(n) " + item.Type);
        System.out.println(item.Description);
        if (item instanceof Armor) {
            Armor instancedItem = (Armor) item;
            System.out.println("It provides " + instancedItem.Defence + " Defence");
        } else if (item instanceof Weapon) {
            Weapon instancedItem = (Weapon) item;
            System.out.println("It can deal at least " + instancedItem.DamageOutputMin + " Damage");
            System.out.println("It can deal at most " + instancedItem.DamageOutputMax + " Damage");
        }
        System.out.println("");
    }
}
