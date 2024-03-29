package src.main.java.WorldMap;

import src.main.java.ItemsAndEquipment.Item;
import src.main.java.Entities.Entity;

import java.util.ArrayList;

/*
 * The entire construction of the Location Class.
 */
public class Location {
    public String Type;
    public Boolean IsPassable;

    public ArrayList<Integer> Coordinates = new ArrayList<Integer>();
    public ArrayList<Item> Items = new ArrayList<Item>();
    public ArrayList<Entity> Entities = new ArrayList<Entity>();

    public Location(
            String locType,
            ArrayList<Integer> coords,
            Boolean passability,
            ArrayList<Item> items, ArrayList<Entity> entities) {
        Type = locType;
        Coordinates = coords;
        IsPassable = passability;
        Items = items;
        Entities = entities;
    }
}
