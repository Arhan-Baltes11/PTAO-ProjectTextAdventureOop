package src.main.java.ItemsAndEquipment.UsableItems;

import src.main.java.ItemsAndEquipment.Item;
import src.main.java.PlayingCharacter.Player;

public class HealingPotion extends Item {

    int HealingAmount;

    public HealingPotion(String iName, String iDescription, int healingAmount) {
        super(iName, iDescription);
        HealingAmount = healingAmount;
    }

    @Override
    public void useItem(Player player) {
        System.out.println("You are healed by " + HealingAmount);
        player.Health = player.Health + HealingAmount;
        if (player.Health > player.MaxHealth) {
            player.Health = player.MaxHealth;
        }
        System.out.println("The Healing Potion is now empty.");
        player.Inventory.remove(this);
    }

}
