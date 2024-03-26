package src.main.java;

import src.main.java.CommandReader.CommandParser;

import java.util.Scanner;


// The point of this class is to set up the game. It also eliminates code from psvm
public class GameLoad {
    public static void StartGame() {
        try {
            GameData dataGame = new GameData();
            dataGame.dataInitiate();

            Scanner comm = new Scanner(System.in);
            CommandParser parse = new CommandParser();

            while (true) {
                if (dataGame.Player.Health == 0) {
                    break;
                }
                System.out.println("Write Next Command");
                String issuedCommand = comm.nextLine();
                if (issuedCommand.equals("quit")) {
                    parse.quitCommand(comm);
                } else {
                    parse.commandGet(issuedCommand, dataGame);
                }
                System.out.println(dataGame.CurrentLocation.get(0));
                System.out.println(dataGame.CurrentLocation.get(1));
            }
            comm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // JSONObject objectFile = new JSONObject(readLocations);
        // WriteLocation.jsonLocationGrid(locationHeader);
    }
}
