package demo.MonsterIntelligence;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Chris on 8/8/2015.
 */
public abstract class BaseBehavior implements Behavior {
    protected ActionFactory actionFactory;

    @Override
    public ActionFactory getActionFactory() {
        return actionFactory;
    }

    @Autowired
    public void setActionFactory(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }
}
