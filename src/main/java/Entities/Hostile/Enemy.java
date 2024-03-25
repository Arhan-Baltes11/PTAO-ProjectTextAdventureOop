package src.main.java.Entities.Hostile;

import src.main.java.Entities.Entity;

public class Enemy extends Entity {

    public Enemy(String name, int health, int attackMin, int attackMax) {
        super(name, health, attackMin, attackMax);
    }

    @Override
    public void respond() {
        System.out.println("The Enemy doesn't respond to your attempts at your attempts at banter.");
    }
}
