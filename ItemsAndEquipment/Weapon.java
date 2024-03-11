package ItemsAndEquipment;

import java.lang.reflect.Field;

public class Weapon extends Equipment  {

    public Weapon(String iName, String iDescription) {
        super(iName, iDescription);
        Type = "Weapon";
    }

}
