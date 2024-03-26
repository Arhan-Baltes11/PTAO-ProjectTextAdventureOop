package src.main.java.FileReader;

import src.main.java.WorldMap.Location;
import src.org.json.JSONObject;
import src.main.java.WorldMap.LocationConstructor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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

            ArrayList<JSONObject> locationObjectList = fileIterator(locationObject);
            ArrayList<JSONObject> itemObjectList = fileIterator(itemObject);
            ArrayList<JSONObject> entityObjectList = fileIterator(entityObject);

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

    public static Map<String, JSONObject> mapIterator(JSONObject objectToIterate) {
        Iterator<String> iterationKeys = objectToIterate.keys();
        Map<String, JSONObject> objectMap = new HashMap();
        while (iterationKeys.hasNext()) {
            String keyBase = iterationKeys.next();
            JSONObject innerObject = objectToIterate.getJSONObject(keyBase);
            objectMap.put(keyBase, innerObject);
        }
        return objectMap;
    }

    public static ArrayList<JSONObject> fileIterator(JSONObject objectToIterate) {
        Iterator<String> iterationKeys = objectToIterate.keys();
        ArrayList<JSONObject> objectList = new ArrayList<>();
        while (iterationKeys.hasNext()) {
            String keyBase = iterationKeys.next();
            JSONObject innerObject = objectToIterate.getJSONObject(keyBase);
            objectList.add(innerObject);
        }
        return objectList;
    }

}
