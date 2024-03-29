package src.main.java.Entities.Hostile;

import src.main.java.Entities.Entity;
import src.main.java.PlayingCharacter.Player;

public class ElderBeast extends Entity {

    public ElderBeast(String name, int health, int attackMin, int attackMax) {
        super(name, health, attackMin, attackMax);
    }

    public void deathSpell(Player player) {
        System.out.println(Name + " Casts the curse of death on " + player.Name + "!");
        System.out.println("DIEEEEE!!!!!!!");
        player.Health = 0;
    }

    @Override
    public void respond() {
        System.out.println("WHAT DO YOU THINK YOU'RE DOING?");
        System.out.println("ARE YOU TRYING TO WASTE MY TIME?!");
        System.out.println("LEAVE YOUR BANTER TO SOMEONE WHO CARES!!");
        System.out.println("I SHALL PUNISH YOU FOR ATTEMPTING THAT!!!!");
    }
}
