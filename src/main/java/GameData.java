package src.main.java;

import java.util.ArrayList;

import src.main.java.Entities.Entity;
import src.main.java.ItemsAndEquipment.Item;
import src.main.java.PlayingCharacter.Player;
import src.main.java.WorldMap.Location;

public class GameData {
    public Player Player;
    public Item[] ItemsOnGround;
    public Entity[] EntitiesOnLocation;
    public Location[] WorldLocation;
    public ArrayList<Integer> CurrentLocation = new ArrayList<>();

    public void dataInitiate() {
        Player = new Player();
        CurrentLocation.add(1);
        CurrentLocation.add(9);
    }
}
