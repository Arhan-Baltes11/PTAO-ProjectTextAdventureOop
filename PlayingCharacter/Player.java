package PlayingCharacter;

import ItemsAndEquipment.*;
import java.util.ArrayList;

public class Player {

    public String Name = "Roald van Hertogenbosch";

    public ArrayList<Item> Inventory = new ArrayList<Item>();

    private Weapon _equippedWeapon;

    private Armor _equippedArmor;

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
        equipWeapon((Weapon) Inventory.get(0));
        equipArmor((Armor) Inventory.get(1));
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

    public void equipWeapon(Weapon weapon) {
        _equippedWeapon = weapon;
        System.out.println(weapon.Name + " Has been equipped.");
    }

    public void equipArmor(Armor armor) {
        _equippedArmor = armor;
        System.out.println(armor.Name + " Has been equipped.");
    }
}
