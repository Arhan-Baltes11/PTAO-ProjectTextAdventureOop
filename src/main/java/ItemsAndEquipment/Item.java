package src.main.java.ItemsAndEquipment;

import src.main.java.GameData;

public class Item {
    public String Type;
    public String Name;
    public String Description;

    public Item(String iName, String iDescription) {
        Type = "Item";
        Name = iName;
        Description = iDescription;
    }

    public void useItem(GameData dataBase) {
        System.out.println("You tried to make use of " + Name + " but you cannot figure out what it's used for.");
    }
}
