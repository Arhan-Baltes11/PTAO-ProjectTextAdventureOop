package src.main.java.ItemsAndEquipment;

public class Armor extends Equipment {

    public int Defence;

    public Armor(String iName, int defenceRating, String iDescription) {
        super(iName, iDescription);
        Type = "Armor";
        Defence = defenceRating;
    }

}
