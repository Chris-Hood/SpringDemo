package demo.MonsterIntelligence;

import demo.Monster;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Chris on 8/8/2015.
 */
@Component("Insane")
public class Insane extends BaseBehavior {
    private static Random random = new Random();

    @Override
    public void takeTurn(Monster actor, List<Monster> targetList) {
        List<Monster> targets = new ArrayList<>(targetList);
        targets.add(actor);
        getActionFactory().getAttack(actor).Act(targets.get(random.nextInt(targets.size())));
    }
}
