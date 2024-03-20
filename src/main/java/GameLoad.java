package src.main.java;

import src.main.java.Entities.Hostile.Enemies.Enemy;
import src.main.java.PlayingCharacter.Player;
import src.main.java.FileReader.ReadJsonDoc;
import src.main.java.FileReader.WriteLocation;
import src.main.java.CommandReader.CommandParser;
import src.main.java.WorldMap.Location;
import src.org.json.JSONArray;
import src.org.json.JSONObject;


import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        try {
            GameData dataGame = new GameData();
            Scanner comm = new Scanner(System.in);
            String pathCanon = new File(".").getCanonicalPath();
            String readLocations = ReadJsonDoc.readObject(pathCanon + "/src/main/java/JsonFiles/Locations.json");
            String locationHeader = pathCanon + "/src/main/java/JsonFiles/Locations.json";
            CommandParser parse = new CommandParser();
            Player player = new Player();

            System.out.println("Write Next Command");
            String issuedCommand = comm.nextLine();
            parse.commandRead(issuedCommand);
            parse.commandResolve(player);

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

        // JSONObject objectFile = new JSONObject(readLocations);
        // WriteLocation.jsonLocationGrid(locationHeader);
    }
}
