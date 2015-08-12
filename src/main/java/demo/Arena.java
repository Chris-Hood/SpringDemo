package demo;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

/**
 * Created by Chris on 8/5/2015.
 */
public class Arena {
    private List<Monster> monsters;
    private Random random = new Random();

    public Arena(List<Monster> monsterList) {
        monsters = monsterList.stream().collect(Collectors.toList());
    }

    public void start() {
        while (monsters.size() > 1) {
            printMonsters();
            takeTurn();
            if (monsters.size() == 1) {
                System.out.println("WINNER is: " + monsters.get(0).getName() + " with " + monsters.get(0).getHp() + " hp left.");
            }

            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void printMonsters() {
        for (Monster monster : monsters) {
            System.out.println(monster.getId() + ": " + monster.getName() + ", hp " + monster.getHp());
        }
    }

    private void takeTurn() {
        PriorityQueue<Monster> monsterTurn = new PriorityQueue<>(
                (Monster m1, Monster m2) -> m2.speedRoll() - m1.speedRoll());

        monsterTurn.addAll(monsters);

        while (!monsterTurn.isEmpty()) {
            Monster actor = monsterTurn.remove();
            if (actor.isDead()) continue;

            List<Monster> targets = getTargets(actor.getId());
            if (targets.isEmpty()) continue;

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            actor.act(targets);
        }
        monsters = monsters.stream().filter(monster -> !monster.isDead()).collect(Collectors.toList());
    }

    private List<Monster> getTargets(final int id) {
        return monsters.stream().filter(monster -> (monster.getId() != id) && (!monster.isDead())).collect(Collectors.toList());
    }
}
