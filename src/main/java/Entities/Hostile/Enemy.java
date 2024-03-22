package src.main.java.Entities.Hostile;

import src.main.java.Entities.Entity;

public class Enemy extends Entity {
    public Enemy(int health, int attackMin, int attackMax) {
        Health = health;
        AttackMax = attackMax;
        AttackMin = attackMin;
    }
}
