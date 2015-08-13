package Game.Entities.Behaviors;

import Game.Entities.Monster;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chris on 8/8/2015.
 */
@Component("Brave")
public class Brave extends BaseBehavior {

    @Override
    public void takeTurn(Monster actor, List<Monster> targetList) {
        Monster target = targetList.stream().max((m1, m2) -> (m1.getHp() + m1.getDamage() + m1.getSpeed()) - (m2.getHp() + m2.getDamage() + m2.getSpeed())).get();
        actionFactory.getAttack(actor).Act(target);
    }
}
