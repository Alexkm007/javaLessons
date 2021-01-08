package web.app.part6;

import org.springframework.stereotype.Component;
@Component
public class ClassicalMusic implements Music{
    public ClassicalMusic() {
    }

//    public static ClassicalMusic getClassicalMusuc(){
//        System.out.println("Создаю новый ClassicalMusic");
//        return new ClassicalMusic();
//    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    public void doMyInit(){
        System.out.println("Делаю мою инициалицаию");
    }

    public void  doMyDestroy(){
        System.out.println("Убиваюсь");
    }
}
