package Game.Entities.Behaviors;

import Game.Entities.Monster;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Chris on 8/9/2015.
 */
@Component("Manual")
public class Manual extends BaseBehavior {

    @Override
    public void takeTurn(Monster actor, List<Monster> targetList) {
        System.out.println(actor.getName() + "'s turn.  Select a target.");

        Scanner reader = new Scanner(System.in);
        int choice;
        while(true) {
            for (int i = 0; i < targetList.size(); ++i) {
                System.out.println(i + ": " + targetList.get(i).getName() + ", hp left: " + targetList.get(i).getHp());
            }
            String choiceInput = reader.next();
            try {
                choice = Integer.parseInt(choiceInput);
                if(choice < 0 || choice >= targetList.size()) {
                    System.out.println("Invalid target index.");
                    continue;
                }
            } catch(Exception e) {
                System.out.println("Invalid input.");
                continue;
            }
            break;
        }
        getActionFactory().getAttack(actor).Act(targetList.get(choice));
    }
}
