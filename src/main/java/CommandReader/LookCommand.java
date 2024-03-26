package src.main.java.CommandReader;

import java.lang.reflect.Field;
import java.util.ArrayList;

import src.main.java.GameData;
import src.main.java.WorldMap.Location;

public class LookCommand {
    protected static void look(GameData dataBase, String direction) {
        switch (direction) {
            case "north":
                findArea(dataBase, false, true);
                break;
            case "south":
                findArea(dataBase, false, false);
                break;
            case "east":
                findArea(dataBase, true, false);
                break;
            case "west":
                findArea(dataBase, true, true);
                break;
            case "around":
                lookHere(dataBase);
                break;
        }
    }

    private static void lookHere(GameData dataBase) {
        for (Location place : dataBase.WorldLocation) {
            if (place.Coordinates.equals(dataBase.CurrentLocation)) {
                describeArea(place);
                return;
            }
        }
    }

    private static void findArea(GameData dataBase, boolean isHorizontal, boolean isNegative) {
        ArrayList<Integer> lookLocation = new ArrayList<>();
        int numberChange = isNegative ? -1 : 1;
        if (!isHorizontal) {
            lookLocation.add(dataBase.CurrentLocation.get(0));
            lookLocation.add(dataBase.CurrentLocation.get(1) + numberChange);
        } else {
            lookLocation.add(dataBase.CurrentLocation.get(0) + numberChange);
            lookLocation.add(dataBase.CurrentLocation.get(1));
        }
        for (Location place : dataBase.WorldLocation) {
            if (place.Coordinates.equals(lookLocation)) {
                describeArea(place);
                return;
            }
        }
    }

    private static void describeArea(Location location) {
        Field[] fields = location.getClass().getFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + ": " + field.get(location));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}
