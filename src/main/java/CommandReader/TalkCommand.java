package src.main.java.CommandReader;

import src.main.java.Entities.Entity;
import src.main.java.WorldMap.Location;
import src.main.java.GameData;

public class TalkCommand {
    protected static void talk(GameData dataBase, String command) {
        command = command.replace("talk ", "");
        command = ".*" + command + ".*";
        for (Location place : dataBase.WorldLocation) {
            if (place.Coordinates.equals(dataBase.CurrentLocation)) {
                if (place.Entities != null) {
                    for (Entity being : place.Entities) {
                        if (being.Name.matches(command)) {
                            being.respond();
                        }
                    }
                }
            }
        }
    }
}
