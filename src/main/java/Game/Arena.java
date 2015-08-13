package Game;

import Game.Entities.Entity;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

/**
 * Created by Chris on 8/5/2015.
 */
public class Arena {
    private List<Entity> entities;
    private Random random = new Random();

    public Arena(List<Entity> entityList) {
        entities = entityList.stream().collect(Collectors.toList());
    }

    public void start() {
        while (entities.size() > 1) {
            printMonsters();
            takeTurn();
            if (entities.size() == 1) {
                System.out.println("WINNER is: " + entities.get(0).getName() + " with " + entities.get(0).getHp() + " hp left.");
            }

            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void printMonsters() {
        for (Entity entity : entities) {
            System.out.println(entity.getId() + ": " + entity.getName() + ", hp " + entity.getHp());
        }
    }

    private void takeTurn() {
        PriorityQueue<Entity> entityTurn = new PriorityQueue<>(
                (Entity m1, Entity m2) -> m2.speedRoll() - m1.speedRoll());

        entityTurn.addAll(entities);

        while (!entityTurn.isEmpty()) {
            Entity actor = entityTurn.remove();
            if (actor.isDead()) continue;

            List<Entity> targets = getTargets(actor.getId());
            if (targets.isEmpty()) continue;

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            actor.act(targets);
        }
        entities = entities.stream().filter(monster -> !monster.isDead()).collect(Collectors.toList());
    }

    private List<Entity> getTargets(final int id) {
        return entities.stream().filter(monster -> (monster.getId() != id) && (!monster.isDead())).collect(Collectors.toList());
    }
}
