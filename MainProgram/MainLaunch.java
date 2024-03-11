package MainProgram;

 import ItemsAndEquipment.*;

public class MainLaunch {
    public static void main(String[] args) {
        System.out.println("Program Lunch");
        Item itemOne = new Item("Implicit Potion", "Dragon Potion that is implicit");
        Weapon swordOne = new Weapon("Sword", "A longsword");
        swordOne.mentionSelf(swordOne);
        itemOne.mentionSelf(itemOne);
    }
}