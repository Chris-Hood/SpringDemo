package demo;

/**
 * Created by Chris on 8/7/2015.
 */
public interface MonsterFactory {

    Monster getMonster(String type);
    Arena getArena(String type);
}
