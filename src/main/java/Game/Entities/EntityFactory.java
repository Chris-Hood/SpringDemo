package Game.Entities;

import Game.Arena;

/**
 * Created by Chris on 8/7/2015.
 */
public interface EntityFactory {

    Entity getMonster(String type);
    Arena getArena(String type);
}
