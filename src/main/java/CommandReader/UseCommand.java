package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;

public class UseCommand {
    protected static void use(GameData dataBase, String command) {
        command = command.replace("use ", "");
        command = ".*" + command + ".*";
        for (Item item : dataBase.Player.Inventory) {
            if (item.Name.toLowerCase().matches(command)) {
                item.useItem(dataBase);
                return;
            }
        }
    }
}
