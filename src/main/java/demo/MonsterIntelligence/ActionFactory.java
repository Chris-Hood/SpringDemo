package demo.MonsterIntelligence;

import demo.Monster;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Chris on 8/8/2015.
 */
@Component("ActionFactory")
public class ActionFactory {

    private static Random random = new Random();

    public Action getAttack(Monster actor) {
        return new Attack(actor, random);
    }
}
