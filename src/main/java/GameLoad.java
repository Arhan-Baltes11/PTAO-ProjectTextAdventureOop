package src.main.java;

import src.main.java.Entities.Hostile.Enemies.Enemy;
import src.main.java.PlayingCharacter.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        Scanner comm = new Scanner(System.in);

        try {
            FileReader reader = new FileReader("src/main/java/test.txt");
            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            String pathName = new File(".").getCanonicalPath();
            File textFile = new File(pathName, "/src/main/java/test.txt");
            System.out.println(textFile);
            System.out.println(textFile.exists());
            System.out.println(pathName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // FileReader reader = new FileReader(absolPath);

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
