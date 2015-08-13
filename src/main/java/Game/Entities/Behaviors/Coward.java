package Game.Entities.Behaviors;

import Game.Entities.Entity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chris on 8/8/2015.
 */
@Component("Coward")
public class Coward extends BaseBehavior {

    @Override
    public void takeTurn(Entity actor, List<Entity> targetList) {
        Entity target = targetList.stream().min((m1, m2) -> (m1.getHp() + m1.getDamage() + m1.getSpeed()) - (m2.getHp() + m2.getDamage() + m2.getSpeed())).get();
        actionFactory.getAttack(actor).Act(target);
    }
}
