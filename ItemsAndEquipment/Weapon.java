package ItemsAndEquipment;


public class Weapon extends Equipment  {

    public int DamageOutputMin;
    public int DamageOutputMax;

    public Weapon(String iName, String iDescription, int damageMin, int damageMax) {
        super(iName, iDescription);
        Type = "Weapon";
        DamageOutputMin = damageMin;
        DamageOutputMax = damageMax;
    }

}
