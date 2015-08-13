package Game.Entities;

import Game.Entities.Behaviors.Behavior;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by Chris on 8/5/2015.
 */
@Service
public class Monster {
    private String name;
    private int damage;
    private int hp;
    private int speed;
    private static int nextId = 0;
    private int id;
    private Behavior behavior;
    private static Random random = new Random();

    public int getSpeed() {
        return speed;
    }

    public int getId() {
        return id;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Monster(Behavior behavior) {
        this.behavior = behavior;
        id = nextId++;
    }

    public void act(List<Monster> targets) {
        behavior.takeTurn(this, targets);
    }

    public int speedRoll() {
        int speedVariance = speed / 2;
        return speed + random.nextInt(speedVariance);
    }

    public boolean isDead() {
        return hp <= 0;
    }
}
