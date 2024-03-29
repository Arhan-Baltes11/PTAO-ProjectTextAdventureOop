package src.main.java.ItemsAndEquipment.UsableItems;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;

public class HealingPotion extends Item {

    public int HealingAmount;

    public HealingPotion(String iName, String iDescription, int healingAmount) {
        super(iName, iDescription);
        Type = "Healing Potion";
        HealingAmount = healingAmount;
    }

    @Override // Override useItem in Item.java
    public void useItem(GameData dataBase) {
        dataBase.Player.Health = dataBase.Player.Health + HealingAmount;
        if (dataBase.Player.Health > dataBase.Player.MaxHealth) {
            HealingAmount = dataBase.Player.MaxHealth - dataBase.Player.Health + 10;
            dataBase.Player.Health = dataBase.Player.MaxHealth;
        }
        System.out.println("You are Healed by " + HealingAmount + ".");
        System.out.println("The Healing Potion is now empty.");
        dataBase.Player.Inventory.remove(this);
    }
}
