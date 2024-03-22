package src.main.java.FileReader;

import java.io.FileWriter;

import src.org.json.JSONArray;
import src.org.json.JSONObject;

public class WriteLocation {
    public static void jsonLocationGrid(String filePath) {
        int[][] plains = { { 1, 9 }, { 1, 10 }, { 1, 11 }, { 1, 12 }, { 1, 13 }, { 2, 13 }, { 3, 2 }, { 3, 3 },
                { 3, 4 }, { 3, 7 }, { 3, 12 }, { 3, 13 }, { 3, 14 }, { 4, 6 }, { 4, 7 }, { 4, 13 }, { 4, 14 },
                { 4, 15 }, { 5, 2 }, { 5, 3 }, { 5, 6 }, { 5, 12 }, { 5, 13 }, { 5, 14 }, { 5, 15 }, { 6, 3 }, { 6, 4 },
                { 6, 5 }, { 6, 6 }, { 6, 7 }, { 6, 13 }, { 6, 14 }, { 6, 15 }, { 7, 3 }, { 7, 4 }, { 7, 5 }, { 8, 3 },
                { 8, 4 }, { 8, 5 }, { 8, 13 }, { 8, 14 }, { 8, 15 }, { 9, 3 }, { 9, 4 }, { 9, 5 }, { 9, 12 }, { 9, 13 },
                { 9, 14 }, { 9, 15 }, { 10, 3 }, { 10, 4 }, { 10, 5 }, { 10, 6 }, { 10, 7 }, { 10, 8 }, { 10, 9 },
                { 10, 10 }, { 10, 13 }, { 10, 14 }, { 10, 15 }, { 11, 3 }, { 11, 4 }, { 11, 5 }, { 11, 6 }, { 11, 6 },
                { 11, 7 }, { 12, 7 }, { 12, 8 }, { 12, 9 }, { 12, 12 }, { 12, 13 }, { 12, 14 }, { 12, 15 }, { 13, 7 },
                { 13, 8 }, { 13, 11 }, { 13, 12 }, { 13, 13 }, { 13, 14 }, { 13, 15 }, { 14, 7 }, { 14, 8 }, { 14, 11 },
                { 14, 12 }, { 14, 13 }, { 14, 14 }, { 14, 15 }, { 15, 11 }, { 15, 12 }, { 15, 13 }, { 15, 15 } };
        int[][] hills = { { 1, 6 }, { 1, 7 }, { 1, 8 }, { 1, 14 }, { 2, 6 }, { 2, 7 }, { 2, 14 }, { 3, 6 }, { 4, 5 },
                { 5, 5 }, { 5, 7 }, { 5, 12 }, { 6, 2 }, { 6, 12 }, { 7, 2 }, { 7, 12 }, { 7, 13 }, { 7, 14 },
                { 7, 15 }, { 8, 2 }, { 8, 12 }, { 9, 2 }, { 10, 2 }, { 10, 11 }, { 10, 12 }, { 11, 1 }, { 11, 2 },
                { 11, 8 }, { 11, 9 }, { 12, 1 }, { 12, 2 }, { 13, 1 }, { 14, 1 }, { 14, 3 }, { 14, 4 }, { 14, 5 },
                { 14, 6 }, { 15, 1 }, { 15, 7 } };
        int[][] walls = { { 2, 8 }, { 2, 9 }, { 2, 10 }, { 2, 11 }, { 2, 12 }, { 3, 8 }, { 4, 8 }, { 4, 11 },
                { 4, 12 }, { 5, 8 }, { 5, 11 }, { 6, 8 }, { 6, 11 }, { 7, 6 }, { 7, 7 }, { 7, 8 }, { 7, 11 },
                { 8, 6 }, { 8, 11 }, { 9, 6 }, { 9, 7 }, { 9, 8 }, { 9, 9 }, { 9, 10 }, { 9, 11 } };
        int[][] roomFloors = { { 3, 9 }, { 3, 10 }, { 4, 9 }, { 4, 10 }, { 5, 9 }, { 5, 10 }, { 6, 9 }, { 6, 10 },
                { 7, 9 }, { 7, 10 }, { 8, 7 }, { 8, 8 }, { 8, 9 }, { 8, 10 } };
        int[][] caverns = { { 13, 4 }, { 13, 5 }, { 14, 3 }, { 14, 4 }, { 14, 5 }, { 14, 6 }, { 15, 3 }, { 15, 4 },
                { 15, 5 } };
        int[][] rivers = { { 11, 10 }, { 11, 11 }, { 11, 12 }, { 11, 13 }, { 11, 14 }, { 11, 15 }, { 12, 10 },
                { 12, 11 }, { 13, 9 }, { 13, 10 }, { 14, 9 }, { 14, 10 }, { 15, 9 }, { 15, 10 } };

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write("{");
            for (int x = 1; x <= 15; x++) {
                for (int y = 1; y <= 15; y++) {
                    JSONObject toWrite = new JSONObject();
                    JSONArray items = new JSONArray();
                    JSONArray entities = new JSONArray();

                    String constructor = "\"Grid(" + x + "," + y + ")\":";

                    if (tableChecker(plains, x, y) == true) {
                        toWrite.put("Type", "Plains");
                        toWrite.put("IsPassable", true);
                    } else if (tableChecker(hills, x, y) == true) {
                        toWrite.put("Type", "Hills");
                        toWrite.put("IsPassable", true);
                    } else if (tableChecker(roomFloors, x, y) == true) {
                        toWrite.put("Type", "RoomFloor");
                        toWrite.put("IsPassable", true);
                    } else if (tableChecker(walls, x, y) == true) {
                        toWrite.put("Type", "Wall");
                        toWrite.put("IsPassable", false);
                    } else if (tableChecker(caverns, x, y) == true) {
                        toWrite.put("Type", "Cavern");
                        toWrite.put("IsPassable", true);
                    } else if (tableChecker(rivers, x, y) == true) {
                        toWrite.put("Type", "River");
                        toWrite.put("IsPassable", true);
                    } else {
                        toWrite.put("Type", "Mountain");
                        toWrite.put("IsPassable", false);
                    }

                        int[] addedCoordinates = { x, y };
                        toWrite.put("Coordinates", addedCoordinates);

                    if (x == 15 && y == 1) {
                        items.put("Engraved Key");
                    } else if (x == 10 && y == 3) {
                        items.put("9 golden coins");
                    } else if (x == 1 && y == 5) {
                        items.put("A Red Herring");
                    } else if (x == 10 && y == 6) {
                        items.put("Longsword");
                        items.put("Chainmail");
                    } else if (x == 6 && y == 7) {
                        items.put("Kraken's Tongue");
                    } else if (x == 8 && y == 7) {
                        items.put("The Dragonslayer");
                    } else if (x == 11 && y == 7) {
                        items.put("A Piece of Silver");
                    } else if (x == 6 && y == 9) {
                        items.put("10 Silver Coins");
                    } else if (x == 8 && y == 10) {
                        items.put("Singing Axe");
                    } else if (x == 13 && y == 11) {
                        items.put("Grimoire of an Aging Occultist");
                    } else if (x == 12 && y == 14) {
                        items.put("Glasses");
                    } else if (x == 15 && y == 15) {
                        items.put("Cornerstone");
                    } else {
                        items.put("");
                    }

                    toWrite.put("Items", items);

                    if (x == 14 && y == 3) {
                        entities.put("Elder Beast");
                    } else if (x == 7 && y == 9) {
                        entities.put("Armed Merchant");
                    } else if (x == 8 && y == 8) {
                        entities.put("Locked Door");
                    } else if (x == 12 && y == 9) {
                        entities.put("River King");
                    } else {
                        entities.put("");
                    }
                    toWrite.put("Entities", entities);

                    constructor += toWrite.toString();
                    if ((x * y == 225) == false) {
                        constructor += ",";
                    }

                    fileWriter.write(constructor);
                    System.out.println("Grid (" + x + " , " + y + ") has been registered");
                }
            }
            fileWriter.write("}");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    private static Boolean tableChecker(int[][] gridArray, int x, int y) {
        for (int[] grid : gridArray) {
            if (grid[0] == x && grid[1] == y) {
                return true;
            }
        }
        return false;
    }
}
