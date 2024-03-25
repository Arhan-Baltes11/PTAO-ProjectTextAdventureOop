package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.*;

public class EquipCommand {
    public void equip(GameData dataBase, String command) {
        for (Item item : dataBase.Player.Inventory) {
            if (item instanceof Equipment) {
                if (item.Name.contains(command)) {
                    if (item instanceof Armor) {
                        Armor toEquip = (Armor) item;

                    }
                }
            }
        }
    }
}
    