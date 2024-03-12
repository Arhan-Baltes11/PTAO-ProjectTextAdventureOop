package Entities;

import PlayingCharacter.Player;
import java.lang.Math;

public class Entity {
    public int Health;
    public int AttackMin;
    public int AttackMax;

    public void attack(Player player) {

        int range = AttackMax - AttackMin + 1;
        int damageOutput = (int) (Math.random() * range) + AttackMin;
        damageOutput = damageOutput - player.EquippedArmor.Defence;
        player.Health = player.Health - damageOutput;
        System.out.println("Damage has been dealt! " + damageOutput + "!");
    }
}
