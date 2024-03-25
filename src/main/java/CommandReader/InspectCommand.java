package src.main.java.CommandReader;

import java.lang.reflect.Field;

import src.main.java.GameData;
import src.main.java.ItemsAndEquipment.Item;

public class InspectCommand {
    protected static void inspect(GameData dataBase, String command) {
        command.replace("inspect ", "");
        command = ".*" + command + ".*";
        for (Item item : dataBase.Player.Inventory) {
            if (item.Name.matches(command)) {
                mentionSelf(item);
                return;
            }
        }
    }

    private static void mentionSelf(Item item) {
        Field[] fields = item.getClass().getFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + ": " + field.get(item));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}
