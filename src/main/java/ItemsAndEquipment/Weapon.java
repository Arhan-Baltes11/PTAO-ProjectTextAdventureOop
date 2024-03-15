package src.main.java.ItemsAndEquipment;

public class Weapon extends Equipment {

    public int DamageOutputMin;
    public int DamageOutputMax;

    public Weapon(String iName, int damageMin, int damageMax, String iDescription) {
        super(iName, iDescription);
        Type = "Weapon";
        DamageOutputMin = damageMin;
        DamageOutputMax = damageMax;
    }

}
