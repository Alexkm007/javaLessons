package xmlLessons.javactest;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement
public class Trains {
    @XmlElement(name = "train")
    private ArrayList<Train> listTrain = new ArrayList<>();

    public Trains() {
        super();
    }

    public ArrayList<Train> getListTrain() {
        return new ArrayList<>(listTrain);
    }


    public void addTrain(Train train){
        if(train != null){
            listTrain.add(train);
        }
    }

    @Override
    public String toString() {
        return "Trains{" +
                "listTrain=" + listTrain +
                '}';
    }
}
