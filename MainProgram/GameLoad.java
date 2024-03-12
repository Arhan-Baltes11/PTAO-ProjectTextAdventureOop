package MainProgram;

import PlayingCharacter.Player;
import Entities.Hostile.Enemies.Enemy;
import java.util.Scanner;

// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        Scanner comm = new Scanner(System.in);
        Player roald = new Player();
        Enemy beast = new Enemy(20, 1, 5);

        while (beast.Health > 0 && roald.Health > 0) {
            roald.attack(beast);
            System.out.println("The creature's health is now " + beast.Health);
            beast.attack(roald);
            System.out.println("Your health is now " + roald.Health);

        }
        // System.out.println("What's your next move?");
        // String nextComm = comm.nextLine();
    }
}
