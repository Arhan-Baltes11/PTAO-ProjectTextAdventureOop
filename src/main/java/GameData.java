package src.main.java;

import java.util.ArrayList;

import src.main.java.FileReader.ReadJsonDoc;
import src.main.java.PlayingCharacter.Player;
import src.main.java.WorldMap.Location;

/*
 * All available data will be stored here as a place for the game to keep track of everything.
 * It will keep track of the current location, player stats, and the map grid.
 * 
 */
public class GameData {
    public Player Player;
    public ArrayList<Location> WorldLocation = new ArrayList<>();
    public ArrayList<Integer> CurrentLocation = new ArrayList<>();

    public void dataInitiate() {
        Player = new Player();
        CurrentLocation.add(8);
        CurrentLocation.add(5);
        WorldLocation = ReadJsonDoc.locationBuilder();
    }
}
