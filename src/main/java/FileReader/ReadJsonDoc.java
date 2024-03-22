package src.main.java.FileReader;

import src.main.java.WorldMap.Location;
import src.org.json.JSONArray;
import src.org.json.JSONObject;
import src.main.java.WorldMap.LocationConstructor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;


public class ReadJsonDoc {
    public static String readObject(String filePath) {
        try {
            String fileContents = new String(Files.readAllBytes(Paths.get(filePath)));
            return fileContents;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Location> locationBuilder() {

        try {
            String pathCanon = new File(".").getCanonicalPath();

            String locationHeader = pathCanon + "/src/main/java/JsonFiles/Locations.json";
            String itemHeader = pathCanon + "/src/main/java/JsonFiles/Items.json";
            String entityHeader = pathCanon + "/src/main/java/JsonFiles/Entities.json";

            JSONObject locationObject = new JSONObject(readObject(locationHeader));
            JSONObject itemObject = new JSONObject(readObject(itemHeader));
            JSONObject entityObject = new JSONObject(readObject(entityHeader));

            ArrayList<JSONObject> locationObjectList = fileIterator(locationObject, entityHeader);
            ArrayList<JSONObject> itemObjectList = fileIterator(itemObject, entityHeader);
            ArrayList<JSONObject> entityObjectList = fileIterator(entityObject, entityHeader);

            ArrayList<Location> locationsList = LocationConstructor.locationArrayConstructor(locationObjectList,
                    itemObjectList,
                    entityObjectList);

            return locationsList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return null;
    }

    private static ArrayList<JSONObject> fileIterator(JSONObject objectToIterate, String pathToFile) {
        Iterator<String> iterationKeys = objectToIterate.keys();
        ArrayList<JSONObject> objectList = new ArrayList<>();
        while (iterationKeys.hasNext()) {
            String keyBase = iterationKeys.next();
            JSONObject innerObject = objectToIterate.getJSONObject(keyBase);
            objectList.add(innerObject);
        }
        return objectList;
    }

    public static ArrayList<Location> locationGenerator(JSONObject jsonOrigin) {
        ArrayList<JSONObject> objectList = new ArrayList<>();
        ArrayList<Location> locationsHandler = new ArrayList<>();
        Iterator<String> iterationKeys = jsonOrigin.keys();
        while (iterationKeys.hasNext()) {
            String keystone = iterationKeys.next();
            JSONObject innerObject = jsonOrigin.getJSONObject(keystone);
            objectList.add(innerObject);
        }
        for (JSONObject object : objectList) {
            String type = object.get("Type").toString();
            String weather = object.get("Weather").toString();
            JSONArray coordinates = object.getJSONArray("Coordinates");
            Boolean isPassable = (Boolean) object.get("IsPassable");
            JSONArray items = object.getJSONArray("Items");
            JSONArray entities = object.getJSONArray("Entities");
            int xVal = coordinates.getInt(0);
            // Location generatedLocation = new Location(type, weather,
            // coordinates.getInt(0), coordinates.getInt(1),
            // isPassable);
            // Location generatedLocation = new Location(object.get("Type"),
            // object.get("Weather"), object.get("Coordinates"), 0, null, null)
        }

        return null;
    }

}
