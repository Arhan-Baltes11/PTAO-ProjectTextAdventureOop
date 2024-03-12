package PlayingCharacter;

import ItemsAndEquipment.*;
import java.util.ArrayList;

import Entities.Entity;

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

    public void attack(Entity target) {
        int range = EquippedWeapon.DamageOutputMax + EquippedWeapon.DamageOutputMin + 1;
        int damageOutput = (int) (Math.random() * range) + EquippedWeapon.DamageOutputMin;
        target.Health = target.Health - damageOutput;
        System.out.println(Name + " attacks the creature! You deal " + damageOutput + " damage!");
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
        EquippedWeapon = weapon;
        System.out.println(weapon.Name + " Has been equipped.");
    }

    public void equipArmor(Armor armor) {
        EquippedArmor = armor;
        System.out.println(armor.Name + " Has been equipped.");
    }
}
