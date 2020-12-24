package xmlLessons.javactest;


import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Trains trains = new Trains();
        trains.addTrain(new Train("London","Paris",new Date(1_234_555_556_789L)));
        trains.addTrain(new Train("London","Monako",new Date(1_234_555_556_789L)));
        trains.addTrain(new Train("London","Lviv",new Date(1_234_555_556_789L)));
        trains.addTrain(new Train("London","kiev",new Date(1_234_555_556_789L)));
        JAXBWorker.saveToXmlFile(trains,new File("./src/main/java/xmlLessons/javactest/trains.xml"));
        Trains tr2 = JAXBWorker.loadFromXmlFile(new File("./src/main/java/xmlLessons/javactest/trains.xml"));
        System.out.println(tr2);
    }
}
