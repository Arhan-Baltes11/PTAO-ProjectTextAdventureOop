package src.main.java.CommandReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

// Quits the game.
public class QuitCommand {
    protected static void quit(Scanner confirmationScanner) {
        String canonPath;
        try {
            canonPath = new File(".").getCanonicalPath();
            String pathToSaveFile = canonPath + "/src/main/java/JsonFiles/Save.json";
            if (!Files.exists(Paths.get(pathToSaveFile))) {
                while (true) {
                    System.out.println("Quitting without a save file. Are you sure? [Y/N]");
                    String textScan = confirmationScanner.nextLine();
                    if (textScan.toUpperCase().equals("Y")) {
                        System.out.println("Very well, quitting without saving.");
                    } else if (textScan.toUpperCase().equals("N")) {
                        System.out.println("Very well, please remember to save first.");
                        return;
                    } else {
                        System.out.println("Please type in either Y or N");
                        continue;
                    }
                    confirmationScanner.close();
                    break;

                }
            }
            System.out.println("Thank you for playing!");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
