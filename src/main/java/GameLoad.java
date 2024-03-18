package src.main.java;

import src.main.java.Entities.Hostile.Enemies.Enemy;
import src.main.java.PlayingCharacter.Player;
import src.main.java.FileReader.ReadJsonDoc;
import src.main.java.FileReader.WriteLocation;
import src.org.json.JSONObject;

import java.io.File;
import java.util.Scanner;


// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        try {
            Scanner comm = new Scanner(System.in);
            String pathCanon = new File(".").getCanonicalPath();
            WriteLocation.jsonLocationGrid(pathCanon + "/src/main/java/JsonFiles/Locations.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // FileReader reader = new FileReader(absolPath);

        // Player roald = new Player();
        // Enemy beast = new Enemy(20, 1, 5);

        // while (beast.Health > 0 && roald.Health > 0) {
        // roald.attack(beast);
        // System.out.println("The creature's health is now " + beast.Health);
        // beast.attack(roald);
        // System.out.println("Your health is now " + roald.Health);

        // }
        // System.out.println("What's your next move?");
        // String nextComm = comm.nextLine();
    }
}
