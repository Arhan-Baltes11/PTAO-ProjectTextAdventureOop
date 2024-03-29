package src.main.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import src.main.java.CommandReader.LoadCommand;
import src.main.java.ItemsAndEquipment.Armor;
import src.main.java.ItemsAndEquipment.Weapon;

public class SafeFileHandler {

    /*
     * This entire Class is to check if save files exist or not
     * On it ont existing, it will simply run as normal.
     * Exposition is to open up with a story.
     */
    public static void saveFileHandler(GameData dataBase) {
        String canonPath;
        try {
            canonPath = new File(".").getCanonicalPath();
            String pathToSaveFile = canonPath + "/src/main/java/JsonFiles/Save.json";
            if (!Files.exists(Paths.get(pathToSaveFile))) {
                exposition();
                dataBase.Player.equipWeapon((Weapon) dataBase.Player.Inventory.get(0));
                dataBase.Player.equipArmor((Armor) dataBase.Player.Inventory.get(1));
                return;
            } else {
                LoadCommand.load(dataBase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exposition() {
        System.out.println("It has been 14 years since the Writer's Guild had accidentally summoned the Elder Beast.");
        System.out.println("Many occultists followed and slaughtered entire kingdoms on that great beast's command.");
        System.out.println("However, there is hope! The Knight's Guild was largely unaffected by the Elder Beast.");
        System.out.println("You are Roald, an aspirant of the Knight's Guild. Your task is to banish the Elder Beast.");
        System.out.println("You know where the Elder Beast is, it's at (14, 3).");
        System.out.println("However, no man has been strong enough to defeat him.");
        System.out.println(
                "The only thing that you know for certain is that there are many items that can help you in this mountain valley.");
        System.out.println("You know of one, named the Cornerstone, which you can find at (15, 15).");
        System.out.println("May your great adventure begin!");
    }
}
