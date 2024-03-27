package src.main.java.Entities.Neutral;

import src.main.java.Entities.Entity;

public class Merchant extends Entity {

    public Merchant(String name, int health, int attackMin, int attackMax) {
        super(name, health, attackMin, attackMax);
    }

    @Override
    public void respond() {
        System.out.println("I must apologize right now, but I'm in no mood to start trading with you.");
        System.out.println(
                "However, I can give you some information on where to find what's beyond that door over yonder.");
        System.out.println("The key should be somewhere up north, along a valley of mountains.");
        System.out.println("It's behind the den of great evil.");
        System.out.println("So, that's really all I got. Apologies if I'm not much more helpful.");
    }

}
