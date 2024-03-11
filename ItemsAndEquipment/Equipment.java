package ItemsAndEquipment;

import java.lang.reflect.Field;

public class Equipment extends Item {

    public Equipment(String iName, String iDescription) {
        super(iName, iDescription);
        Type = "Equipment";
    }
}
