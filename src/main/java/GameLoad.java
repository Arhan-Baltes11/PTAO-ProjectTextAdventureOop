package src.main.java;

import src.main.java.PlayingCharacter.Player;
import src.main.java.FileReader.ReadJsonDoc;
import src.main.java.FileReader.WriteLocation;
import src.main.java.CommandReader.CommandParser;
import src.main.java.Entities.Hostile.Enemy;
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
            dataGame.dataInitiate();
            Scanner comm = new Scanner(System.in);

            CommandParser parse = new CommandParser();

            while (true) {
                System.out.println("Write Next Command");
                String issuedCommand = comm.nextLine();
                parse.commandGet(issuedCommand, dataGame);
                System.out.println(dataGame.CurrentLocation.get(0));
                System.out.println(dataGame.CurrentLocation.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // JSONObject objectFile = new JSONObject(readLocations);
        // WriteLocation.jsonLocationGrid(locationHeader);
    }
}
