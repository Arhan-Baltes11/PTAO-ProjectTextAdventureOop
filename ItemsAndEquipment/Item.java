package ItemsAndEquipment;

import java.lang.reflect.Field;

public class Item {
    public String Type;
    public String Name;
    public String Description;

    public Item(String iName, String iDescription) {
        Type = "Item";
        Name = iName;
        Description = iDescription;
    }

    public void mentionSelf(Item item) {
        Field[] fields = item.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                System.out.println(field.get(item));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
