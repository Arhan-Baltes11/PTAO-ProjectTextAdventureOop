package src.main.java.PlayingCharacter;

import java.util.ArrayList;

import src.main.java.Entities.Entity;
import src.main.java.ItemsAndEquipment.*;

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

    public void equipWeapon(Weapon weapon) {
        EquippedWeapon = weapon;
        System.out.println(weapon.Name + " Has been equipped.");
    }

    public void equipArmor(Armor armor) {
        EquippedArmor = armor;
        System.out.println(armor.Name + " Has been equipped.");
    }
}
