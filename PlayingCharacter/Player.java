package PlayingCharacter;

import ItemsAndEquipment.*;
import java.util.ArrayList;

public class Player {

    public String Name = "Roald van Hertogenbosch";

    public ArrayList<Item> Inventory = new ArrayList<Item>();

    public Player() {
        Inventory.add(new Weapon("Shortsword", "A shortsword made of simple metal."));
        Inventory.add(new Armor("Common Clohing", "Clothing worn by commoners. Better than nothing."));
        Inventory.add(new Item("Potion of Minor Healing", "A Potion that cures 5health from the player."));
        for (Item equips : Inventory) {
            if (equips instanceof Equipment) {
                Equipment toEquip = (Equipment) equips;
                toEquip.IsEquipped = true;
            }
        }
    }

    public void checkInventory() {
        System.out.println("Your Inventory Contains " + Inventory.size() + " Items");
        for (Item item : Inventory) {
            String itemInInventory = item.Name;
            if (item instanceof Equipment) {
                Equipment isEquip = (Equipment) item;
                if (isEquip.IsEquipped) {
                    itemInInventory += "(e)";
                }
            }
            System.out.println(itemInInventory);
        }
    }
}
