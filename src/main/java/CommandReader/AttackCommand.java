package src.main.java.CommandReader;

import src.main.java.GameData;
import src.main.java.Entities.Entity;
import src.main.java.PlayingCharacter.Player;
import src.main.java.WorldMap.Location;

public class AttackCommand {
    protected static void attack(GameData dataBase, String command) {
        command = command.replace("attack ", "");
        command = ".*" + command + ".*";
        for (Location place : dataBase.WorldLocation) {
            if (place.Coordinates.equals(dataBase.CurrentLocation)) {
                if (place.Entities != null) {
                    for (Entity being : place.Entities) {
                        if (being.Name.matches(command)) {
                            calculateDamage(being, dataBase.Player);
                            if (being.Health > 0) {
                                being.attack(dataBase.Player);
                            } else {
                                System.out.println("There is no response. It's just a corpse.");
                            }
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("You swing at... thin air.");
    }

    private static void calculateDamage(Entity target, Player player) {
        int range = player.EquippedWeapon.DamageOutputMax + player.EquippedWeapon.DamageOutputMin + 1;
        int damageOutput = (int) (Math.random() * range) + player.EquippedWeapon.DamageOutputMin;
        target.Health = target.Health - damageOutput;
        System.out.println(player.Name + " attacks " + target.Name + "! You deal " + damageOutput + " damage!");
        if (target.Health <= 0) {
            System.out.println("Player has killed " + target.Name + "!");
        }
    }

}
