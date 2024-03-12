package ItemsAndEquipment;

public class Equipment extends Item {

    public boolean IsEquipped;

    public Equipment(String iName, String iDescription) {
        super(iName, iDescription);
        Type = "Equipment";
        IsEquipped = false;
    }
}
