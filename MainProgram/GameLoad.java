package MainProgram;

import PlayingCharacter.Player;
import Entities.Hostile.Enemies.Enemy;

// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        Player roald = new Player();
        roald.checkInventory();
        Enemy beast = new Enemy(20, 1, 10);
        beast.attack(roald);
        System.out.println("Player health is now = " + roald.Health);
    }
}
