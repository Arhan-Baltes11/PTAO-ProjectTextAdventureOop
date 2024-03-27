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
            CommandParser parse = new CommandParser();

            while (true) {
                if (dataGame.Player.Health == 0) {
                    break;
                }
                System.out.println("You are on the following coordinates: " + dataGame.CurrentLocation.get(0) + ", "
                        + dataGame.CurrentLocation.get(1));
                System.out.println("What will you do now?");
                String issuedCommand = comm.nextLine();
                if (issuedCommand.equals("quit")) {
                    parse.quitCommand(comm);
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
