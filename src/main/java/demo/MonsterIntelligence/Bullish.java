package demo.MonsterIntelligence;

import demo.Monster;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chris on 8/8/2015.
 */
@Component("Bullish")
public class Bullish extends BaseBehavior {

    @Override
    public void takeTurn(Monster actor, List<Monster> targetList) {
        Monster target = targetList.stream().max((m1, m2) -> (m1.getHp()) - (m2.getHp())).get();
        actionFactory.getAttack(actor).Act(target);
    }
}
