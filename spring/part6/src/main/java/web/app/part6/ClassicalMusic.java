package web.app.part6;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClassicalMusic implements Music{
    public ClassicalMusic() {
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    @PostConstruct
    public void doMyInit(){
        System.out.println("Делаю мою инициалицаию");
    }

    @PreDestroy
    public void  doMyDestroy(){
        System.out.println("Убиваюсь");
    }
}
