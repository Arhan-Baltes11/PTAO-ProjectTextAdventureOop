package src.main.java;

import java.util.ArrayList;

import src.main.java.Entities.Entity;
import src.main.java.FileReader.ReadJsonDoc;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.PlayingCharacter.Player;
import src.main.java.WorldMap.Location;

public class GameData {
    public Player Player;
    public Item[] ItemsOnGround;
    public Entity[] EntitiesOnLocation;
    public ArrayList<Location> WorldLocation = new ArrayList<>();
    public ArrayList<Integer> CurrentLocation = new ArrayList<>();

    public void dataInitiate() {
        Player = new Player();
        CurrentLocation.add(8);
        CurrentLocation.add(5);
        WorldLocation = ReadJsonDoc.locationBuilder();
    }
}
