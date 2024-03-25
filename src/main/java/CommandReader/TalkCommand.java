package src.main.java.CommandReader;

import src.main.java.Entities.Entity;

import src.main.java.GameData;

public class TalkCommand {
    protected static void talk(GameData dataBase, String command) {
        if (!command.contains("to")) {
            System.out.println("Talk to who?");
        } else {
            for (Entity being : dataBase.EntitiesOnLocation) {
                being.respond();
            }
        }
    }
}
