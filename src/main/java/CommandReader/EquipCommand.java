package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.*;

public class EquipCommand {
    protected static void equip(GameData dataBase, String command) {
        command = command.replace("equip ", "");
        command = ".*" + command + ".*";
        for (Item item : dataBase.Player.Inventory) {
            if (item instanceof Equipment) {
                if (item.Name.toLowerCase().matches(command)) {
                    if (item instanceof Armor) {
                        Armor toEquip = (Armor) item;
                        toEquip.IsEquipped = true;
                        unequip(dataBase, dataBase.Player.EquippedArmor.Name);
                        dataBase.Player.EquippedArmor = toEquip;
                        return;
                    } else {
                        Weapon toEquip = (Weapon) item;
                        toEquip.IsEquipped = true;
                        unequip(dataBase, dataBase.Player.EquippedWeapon.Name);
                        dataBase.Player.EquippedWeapon = toEquip;
                        return;
                    }
                }
            }
        }
    }

    protected static void unequip(GameData dataBase, String command) {
        command = command.replace("unequip ", "");
        for (Item equipment : dataBase.Player.Inventory) {
            if (equipment.Name.toLowerCase().equals(command)) {
                if (equipment instanceof Armor) {
                    Armor iteratedEquipment = (Armor) equipment;
                    iteratedEquipment.IsEquipped = false;
                    dataBase.Player.EquippedArmor = new Armor("Nothing", 0,
                            "You are wearing nothing. Why? Put on some clothes!");
                    return;
                } else {
                    Weapon iteratedEquipment = (Weapon) equipment;
                    iteratedEquipment.IsEquipped = false;
                    dataBase.Player.EquippedWeapon = new Weapon("Fists", 1, 4, "Put 'em up!");
                    return;
                }
            }
        }
    }

    // private static void unequip(GameData dataBase, Equipment toRemove) {
    // for (Item equipment : dataBase.Player.Inventory) {
    // if (equipment.equals(toRemove)) {
    // if (equipment instanceof Armor) {
    // Armor iteratedEquipment = (Armor) equipment;
    // iteratedEquipment.IsEquipped = false;
    // return;
    // } else {
    // Weapon iteratedEquipment = (Weapon) equipment;
    // iteratedEquipment.IsEquipped = false;
    // return;
    // }

    // }
    // }
    // }
}
    