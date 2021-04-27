package CreationalPatterns.factory;

public class Factory {
    public static void main(String[] args) {

        Factory factory = new Factory();

        Car car1 = factory.create("Toyota");
        car1.drive();

        Car car2 = factory.create("Audi");
        car2.drive();

    }

    public Car create(String typeOfCar){

        switch (typeOfCar){
            case "Toyota" : return new Toyota();
            case "Audi" : return new Audi();
        }

        return null;
    }

}
