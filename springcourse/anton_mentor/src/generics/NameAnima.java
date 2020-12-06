package generics;

public class NameAnima <T>{

    private T animal;

    public NameAnima(T animal) {
        this.animal = animal;
    }

    public void getName(T animal2){
        System.out.println(animal);
        System.out.println(animal2);
    }
}
