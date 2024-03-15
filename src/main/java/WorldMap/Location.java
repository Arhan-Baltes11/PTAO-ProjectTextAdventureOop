package src.main.java.WorldMap;

import java.util.ArrayList;

public class Location {
    public String Name;
    public String Type;
    public String Weather;

    public ArrayList<Integer> Coordinates = new ArrayList<Integer>();

    public Location(
            String locName, String locType,
            String locWeather,
            int xAx,
            int yAx) {
        Name = locName;
        Type = locType;
        Weather = locWeather;
    }
}
