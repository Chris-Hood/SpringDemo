package Game.Entities.Behaviors;

import Game.Entities.Actions.ActionFactory;
import Game.Entities.Entity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Chris on 8/7/2015.
 */
@Component("Behavior")
public interface Behavior {

    ActionFactory getActionFactory();

    void takeTurn(Entity actor, List<Entity> targetList);
}
