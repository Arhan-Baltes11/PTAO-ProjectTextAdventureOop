package src.main.java.WorldMap;

import src.main.java.ItemsAndEquipment.*;
import src.main.java.Entities.Entity;
import src.main.java.Entities.Neutral.*;
import src.main.java.Entities.Hostile.*;

import java.util.ArrayList;

import src.org.json.JSONArray;
import src.org.json.JSONObject;

public class LocationConstructor {
    public static ArrayList<Location> locationArrayConstructor(
            ArrayList<JSONObject> locations,
            ArrayList<JSONObject> items,
            ArrayList<JSONObject> entities) {

        try {

            ArrayList<Location> locationList = new ArrayList<>();

        for (JSONObject location : locations) {

            String type = location.get("Type").toString();
            JSONArray coordinates = location.getJSONArray("Coordinates");
            ArrayList<Integer> coords = new ArrayList<>();

            for (Object number : coordinates) {
                coords.add((int) number);
            }

            Boolean isPassable = (Boolean) location.get("IsPassable");
            JSONArray itemsAtLocation = location.getJSONArray("Items");
            JSONArray entitiesAtLocation = location.getJSONArray("Entities");

            ArrayList<Item> locationItems = itemLister(items, itemsAtLocation);
            ArrayList<Entity> locationEntities = entityLister(entities, entitiesAtLocation);

            Location locationInsert = new Location(type, coords, isPassable,
                    locationItems, locationEntities);

            locationList.add(locationInsert);
        }
        return locationList;

    } catch (Exception e) {
        System.out.println(e.getStackTrace());
        System.out.println(e.getLocalizedMessage());
        return null;
    }
    }

    private static ArrayList<Item> itemLister(ArrayList<JSONObject> itemsObject, JSONArray itemsArray) {

        ArrayList<Item> itemsList = new ArrayList<>();

        if (itemsArray.get(0) == "") {
            return new ArrayList<Item>();
        }

        for (JSONObject item : itemsObject) {
            for (Object itemName : itemsArray) {
                if (itemName.toString().equals(item.get("Name"))) {
                    if (item.get("Type").equals("Weapon")) {
                        Weapon weapon = new Weapon(item.getString("Name"), item.getInt("DamageOutputMin"),
                                item.getInt("DamageOutputMax"), item.getString("Description"));
                        itemsList.add(weapon);
                    } else if (item.get("Type").equals("Armor")) {
                        Armor armor = new Armor(item.getString("Name"), item.getInt("Defence"),
                                item.getString("Description"));
                        itemsList.add(armor);
                    } else {
                        Item regular = new Item(item.getString("Name"), item.getString("Description"));
                        itemsList.add(regular);
                    }
                }
            }
        }
        return itemsList;
    }

    private static ArrayList<Entity> entityLister(ArrayList<JSONObject> entitiesObject, JSONArray entitiesArray) {

        ArrayList<Entity> entityArrayList = new ArrayList<>();

        if (entitiesArray.get(0) == "") {
            return new ArrayList<Entity>();
        }

        for (JSONObject entity : entitiesObject) {
            for (Object entityName : entitiesArray) {
                if (entityName.toString().equals(entity.get("Name"))) {
                    if (entity.get("Name").equals("Elder Beast")) {
                        entityArrayList.add(new ElderBeast());
                    } else if (entity.get("Name").equals("Armed Merchant")) {
                        entityArrayList.add(new Merchant());
                    } else if (entity.get("Name").equals("River King")) {
                        entityArrayList.add(new RiverKing());
                    } else if (entity.get("Name").equals("Locked Door")) {
                        entityArrayList.add(new Entity());
                    }
                }
            }
        }
        return entityArrayList;
    }
}
