package MainProgram;

import PlayingCharacter.Player;

// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        Player roald = new Player();
        roald.checkInventory();
    }
}
