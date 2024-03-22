package src.main.java.WorldMap;

import src.main.java.ItemsAndEquipment.Item;
import src.main.java.Entities.Entity;

import java.util.ArrayList;

public class Location {
    public String Type;
    public Boolean IsPassable;

    public ArrayList<Integer> Coordinates = new ArrayList<Integer>();
    public ArrayList<Item> Items = new ArrayList<Item>();
    public ArrayList<Entity> Entities = new ArrayList<Entity>();

    public Location(
            String locType,
            int xAx,
            int yAx,
            Boolean passability,
            ArrayList<Item> items, ArrayList<Entity> entities) {
        Type = locType;
        Coordinates.add(xAx, yAx);
        IsPassable = passability;
        Items = items;
        Entities = entities;
    }
}
