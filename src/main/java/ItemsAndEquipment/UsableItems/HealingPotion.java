package src.main.java.ItemsAndEquipment.UsableItems;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;

public class HealingPotion extends Item {

    int HealingAmount;

    public HealingPotion(String iName, String iDescription, int healingAmount) {
        super(iName, iDescription);
        HealingAmount = healingAmount;
    }

    @Override
    public void useItem(GameData dataBase) {
        System.out.println("You are healed by " + HealingAmount);
        dataBase.Player.Health = dataBase.Player.Health + HealingAmount;
        if (dataBase.Player.Health > dataBase.Player.MaxHealth) {
            dataBase.Player.Health = dataBase.Player.MaxHealth;
        }
        System.out.println("The Healing Potion is now empty.");
        dataBase.Player.Inventory.remove(this);
    }

}
