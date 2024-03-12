package Entities.Hostile.Enemies;

import Entities.Entity;

public class Enemy extends Entity {
    public Enemy(int health, int attackMin, int attackMax) {
        Health = health;
        AttackMax = attackMax;
        AttackMin = attackMin;
    }
}
