package web.app.part5;

public class ClassicalMusic implements Music{
    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusuc(){
        System.out.println("Создаю новый ClassicalMusic");
        return new ClassicalMusic();
    }

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
