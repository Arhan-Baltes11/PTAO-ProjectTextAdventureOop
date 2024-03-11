package ItemsAndEquipment;

import java.lang.reflect.Field;

public class Item implements IType {
    public IType Type;
    public String Name;
    public String Description;

    public Item(String iName, String iDescription) {
        Name = iName;
        Description = iDescription;
    }

    public void mentionSelf(Item item) {
        Field[] fields = item.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                try {
                    System.out.println(field.get(item));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (field.getType() == IType.class) {
                System.out.println(field.getName());
            }
        }
    }
}
