package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.Entities.Entity;
import src.main.java.PlayingCharacter.Player;

public class AttackCommand {
    protected static void attack(GameData dataBase, String entityName) {
        for (Entity being : dataBase.EntitiesOnLocation) {
            if (being.Name.contains(entityName)) {
                calculateDamage(being, dataBase.Player);
                return;
            }
        }
        System.out.println("You swing at... thin air.");
    }

    private static void calculateDamage(Entity target, Player player) {
        int range = player.EquippedWeapon.DamageOutputMax + player.EquippedWeapon.DamageOutputMin + 1;
        int damageOutput = (int) (Math.random() * range) + player.EquippedWeapon.DamageOutputMin;
        target.Health = target.Health - damageOutput;
        System.out.println(player.Name + " attacks " + target.Name + "! You deal " + damageOutput + " damage!");
    }

}
