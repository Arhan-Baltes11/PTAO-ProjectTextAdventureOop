package src.main.java.PlayingCharacter;

import java.util.ArrayList;

import src.main.java.Entities.Entity;
import src.main.java.ItemsAndEquipment.*;
import src.main.java.ItemsAndEquipment.UsableItems.HealingPotion;

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
        Inventory.add(new Weapon("Tall Sword", 2, 8, "Named after Henrikus Tall."));
        for (Item equips : Inventory) {
            if (equips instanceof Equipment) {
                Equipment toEquip = (Equipment) equips;
                toEquip.IsEquipped = true;
            }
        }
        equipWeapon((Weapon) Inventory.get(0));
        equipArmor((Armor) Inventory.get(1));
    }

    public void equipWeapon(Weapon weapon) {
        EquippedWeapon = weapon;
        System.out.println(weapon.Name + " Has been equipped.");
    }

    public void equipArmor(Armor armor) {
        EquippedArmor = armor;
        System.out.println(armor.Name + " Has been equipped.");
    }
}
