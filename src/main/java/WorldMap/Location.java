package src.main.java.WorldMap;

import src.main.java.ItemsAndEquipment.Item;
import src.main.java.Entities.Entity;

import java.util.ArrayList;

public class Location {
    public String Type;
    public String Weather;
    public Boolean IsPassable;

    public ArrayList<Integer> Coordinates = new ArrayList<Integer>();
    public ArrayList<Item> Items = new ArrayList<Item>();
    public ArrayList<Entity> Entities = new ArrayList<Entity>();

    public Location(
            String locType,
            String locWeather,
            int xAx,
            int yAx,
            Boolean passability,
            Item[] items, Entity[] entities) {
        Type = locType;
        Weather = locWeather;
        Coordinates.add(xAx, yAx);
        IsPassable = passability;
        for (Item item : items) {
            if (item.Name == "") {
                break;
            } else {
                Items.add(item);
            }
        }

        for (Entity being : entities) {
            if (being.Name == "") {
                break;
            } else {
                Entities.add(being);
            }
        }
    }
}
