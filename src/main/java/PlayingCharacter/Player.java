package src.main.java.PlayingCharacter;

import java.util.ArrayList;

import src.main.java.ItemsAndEquipment.*;
import src.main.java.ItemsAndEquipment.UsableItems.HealingPotion;

/*
 * The player class, with initial set up and everything.
 */

public class Player {

    public String Name = "Roald";

    public int Health = 20;

    public int MaxHealth = 20;

    public ArrayList<Item> Inventory = new ArrayList<Item>();

    public Weapon EquippedWeapon;

    public Armor EquippedArmor;

    public Player() {
        Inventory.add(new Weapon("Shortsword", 1, 6, "A shortsword made of simple metal."));
        Inventory.add(new Armor("Common Clohing", 1, "Clothing worn by commoners. Better than nothing."));
        Inventory.add(new HealingPotion("Healing Potion", "A Potion that cures 10 health from the player.", 10));
    }

    public void equipWeapon(Weapon weapon) {
        EquippedWeapon = weapon;
        weapon.IsEquipped = true;
        System.out.println(weapon.Name + " Has been equipped.");
    }

    public void equipArmor(Armor armor) {
        EquippedArmor = armor;
        armor.IsEquipped = true;
        System.out.println(armor.Name + " Has been equipped.");
    }
}
