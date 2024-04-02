package src.main.java.Entities.Neutral;

import src.main.java.Entities.Entity;

public class RiverKing extends Entity {

    public RiverKing(String name, int health, int attackMin, int attackMax) {
        super(name, health, attackMin, attackMax);
    }

    @Override
    public void respond() {
        System.out.println("Hail to thee, oh gracious knight!");
        System.out.println("Perhaps thou couldst assist me on an errand?");
        System.out.println("As thou may understand, woe is me for losing my glasses.");
        System.out.println("Thus I am incapable of perceiving anything.");
        System.out.println("Wouldst thou find me my beloved glasses?");
    }
}
