package CreationalPatterns.singleton;

public class Singleton {

    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    private Singleton() {
    }

    public void SayHi(){
        System.out.println("Hi");
    }

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        singleton.SayHi();
    }

}
