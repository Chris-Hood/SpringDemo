package Game;

import Game.Entities.EntityFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        EntityFactory fact = (EntityFactory) context.getBean("entityFactory");

        Arena arena = fact.getArena("arena");
        arena.start();
    }
}
