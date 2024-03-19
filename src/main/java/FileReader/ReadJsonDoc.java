package src.main.java.FileReader;

import src.main.java.WorldMap.Location;
import src.org.json.JSONArray;
import src.org.json.JSONObject;

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
            JSONArray coordinates = object.getJSONArray(weather);
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
