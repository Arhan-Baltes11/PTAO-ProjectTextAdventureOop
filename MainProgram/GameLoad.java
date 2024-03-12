package MainProgram;

import ItemsAndEquipment.Item;
import ItemsAndEquipment.Weapon;
import PlayingCharacter.Player;

// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {

        Item itemOne = new Item("Implicit Potion", "Dragon Potion that is implicit");
        Weapon swordOne = new Weapon("Sword", "A longsword");
        swordOne.mentionSelf(swordOne);
        itemOne.mentionSelf(itemOne);
        Player roald = new Player();
        roald.checkInventory();
    }
}
