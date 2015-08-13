package Game.Entities.Actions;

import Game.Entities.Monster;

import java.util.Random;

/**
 * Created by Chris on 8/8/2015.
 */
public class Attack implements Action {
    private Random random;
    private Monster actor;

    public Attack(Monster actor, Random random) {
        this.actor = actor;
        this.random = random;
    }

    @Override
    public void Act(Monster target) {
        int hp = target.getHp();
        int variance = actor.getDamage() / 4;
        int damageRoll = actor.getDamage() + random.nextInt(variance);
        hp -= damageRoll;
        target.setHp(hp);
        System.out.println(actor.getName() + " attacks " + target.getName() + " for " + damageRoll + " damage.");
        if (target.getHp() <= 0) {
            target.setHp(0);
        }
        System.out.println(target.getName() + " has " + target.getHp() + " hp left.");
    }
}
