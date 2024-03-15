package src.main.java.Entities;

import java.lang.Math;

import src.main.java.PlayingCharacter.Player;

public class Entity {
    public int Health;
    public int AttackMin;
    public int AttackMax;

    public void attack(Player player) {

        int range = AttackMax - AttackMin + 1;
        int damageOutput = (int) (Math.random() * range) + AttackMin;
        damageOutput = damageOutput - player.EquippedArmor.Defence;
        player.Health = player.Health - damageOutput;
        System.out.println("Foe has dealt damage! It deals " + damageOutput + " damage!");
    }
}
