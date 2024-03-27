package src.main.java.Entities;

import java.lang.Math;

import src.main.java.PlayingCharacter.Player;

public class Entity {
    public String Name;
    public int Health;
    public int AttackMin;
    public int AttackMax;

    public Entity(String name, int health, int attackMin, int attackMax) {
        Name = name;
        Health = health;
        AttackMin = attackMin;
        AttackMax = attackMax;
    }

    public void attack(Player player) {

        int range = AttackMax - AttackMin + 1;
        int damageOutput = (int) (Math.random() * range) + AttackMin;
        damageOutput = damageOutput - player.EquippedArmor.Defence;
        player.Health = player.Health - damageOutput;
        System.out.println(Name + " deals damage! It deals " + damageOutput + " damage!");
        if (player.Health < 0) {
            player.Health = 0;
        }
        System.out.println(player.Name + " has " + player.Health + " health left!");
    }

    public void respond() {
        System.out.println("Hello! What can I do for you?");
    }
}
