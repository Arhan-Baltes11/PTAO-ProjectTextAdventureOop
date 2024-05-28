package src.main.java;

import src.main.java.CommandReader.CommandParser;

import java.util.Scanner;


// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        try {
            GameData dataGame = new GameData();
            dataGame.dataInitiate();
            SafeFileHandler.saveFileHandler(dataGame);

            Scanner comm = new Scanner(System.in);
            CommandParser parse = new CommandParser(); // To read commands input in the scanner.

            while (true) {
                if (dataGame.Player.Health <= 0) {
                    System.out.println("Player has died! Game over!!");
                    break;
                }
                /*
                 * Whenever you enter a new grid,
                 * You will always check the area around you first.
                 * This can lead to console bloat, but it's not too big of a problem.
                 */
                parse.commandGet("look around", dataGame);
                System.out.println("What will you do now?");
                String issuedCommand = comm.nextLine();
                issuedCommand = issuedCommand.toLowerCase();
                if (issuedCommand.equals("quit") || issuedCommand.equals("help")) {
                    parse.scanCommand(comm, issuedCommand);
                } else {
                    parse.commandGet(issuedCommand, dataGame);
                }

            }
            comm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // JSONObject objectFile = new JSONObject(readLocations);
        // WriteLocation.jsonLocationGrid(locationHeader);
    }
}
